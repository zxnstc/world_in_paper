package com.example.world_in_paper_backend.service.Imp;

import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.mapper.UserMapper;
import com.example.world_in_paper_backend.service.UserService;
import com.example.world_in_paper_backend.utils.JedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String account;

    @Override
    public R<Map<String,String>> login(String username, String password, HttpSession session) {
        User u = userMapper.getUserByUsername(username);
        if (u == null) {
            return R.error("用户不存在");
        }
        else if (!u.getPassword().equals(password)) {
            System.out.println("登录失败");
            return R.error("密码错误");
        } else if(u.getState()==1) {
            return R.error("用户已被封禁");
        } else {
            System.out.println("登录成功");
            R<Map<String,String>> r = R.success("登录成功");
            Map<String,String> map = new HashMap<>();
            map.put("user_id",u.getId());
            map.put("user_name",u.getUsername());
            map.put("user_avatar",u.getAvatar());
            map.put("user_introduction",u.getIntroduction());
            map.put("user_email",u.getEmail());
            map.put("rank",String.valueOf(u.getRank()));
            map.put("role_id",String.valueOf(u.getRoleId()));
            session.setAttribute("userId", u.getId());
            r.setData(map);
            return r;
        }

    }

    @Override
    public R<String> sendMail(String email, String subject, String vCode) {
        try {
            log.info("发送邮件开始");
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(account);
            message.setTo(email);
            message.setSubject(subject);
            String body = "您好，您的验证码是：" + vCode + "。有效期为5分钟";
            message.setText(body);
            log.info("信息：" + message);
            javaMailSender.send(message);
            log.info("发送邮件成功");
            Jedis jedis = JedisUtils.getJedis();
            jedis.set(email, vCode);
            jedis.expire(email, 300);
            jedis.close();
            log.info("验证码存入redis成功");
            return R.success("发送成功");
        } catch (Exception e) {
            return R.error("发送失败");
        }

    }

    @Override
    public R<String> register(String username, String password, String email, String vCode) {
        Jedis jedis = JedisUtils.getJedis();
        if (jedis.exists(email)) {
            if (jedis.get(email).equals(vCode)) {
                if (userMapper.getUserByUsername(username) != null) {
                    return R.error("用户名已存在");
                }
                userMapper.register(username, password, email);
                return R.success("注册成功");
            } else {
                return R.error("验证码错误");
            }
        } else {
            return R.error("验证码已过期");
        }
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(Integer.valueOf(id));
    }

    @Override
    public R<User> updateUserInfo(String id, String avatar, String introduction) {
        if(avatar==null&&introduction==null){
            return R.success("没有修改任何信息");
        }
        if(avatar==null)
        {
            userMapper.updateUserIntroduction(id,introduction);
            User u = userMapper.getUserById(Integer.valueOf(id));

            return R.success(u,"修改个性签名成功");
        }
        if (introduction==null)
        {

            userMapper.updateUserAvatar(id,avatar);
            User u = userMapper.getUserById(Integer.valueOf(id));
            return R.success(u,"修改头像成功");
        }
        Integer result=userMapper.updateUserInfo(id,avatar,introduction);
        if (result == 1) {
            User u = userMapper.getUserById(Integer.valueOf(id));
            return R.success(u,"修改信息成功");
        } else {
            return R.error("修改信息失败");
        }
    }

    @Override
    public R<String> disableUser(String id) {
        Integer result=userMapper.disableUser(id);
        if (result == 1) {
            return R.success("禁用用户成功");
        } else {
            return R.error("禁用用户失败");
        }
    }

    @Override
    public R<String> updateUserRole(String userId, String roleId) {
        Integer result=userMapper.updateUserRole(userId,roleId);
        if (result == 1) {
            return R.success("修改用户角色成功");
        } else {
            return R.error("修改用户角色失败");
        }
    }

    @Override
    public R<Map<String,Object>> keepSession(HttpSession session) {
        String userId = (String)session.getAttribute("userId");
        log.info("keepSession userId:{}",userId);
        if(userId==null){
            return R.error("用户未登录");
        }
        User u = userMapper.getUserById(Integer.valueOf(userId));
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",u.getId());
        map.put("user_name",u.getUsername());
        map.put("user_avatar",u.getAvatar());
        map.put("user_introduction",u.getIntroduction());
        map.put("user_email",u.getEmail());
        map.put("rank",String.valueOf(u.getRank()));
        map.put("role_id",String.valueOf(u.getRoleId()));
        return R.success(map);

    }

    @Override
    public R<List<User>> getUserList(String username) {
        if (username == null) {
            List<User> allUser = userMapper.getAllUser();
            for (User u : allUser) {
                u.setPassword(null);
            }

            return R.success(allUser);
        } else {
            List<User> allUser = userMapper.searchUserByUsername(username);
            for (User u : allUser) {
                u.setPassword(null);
            }
            return R.success(allUser);
        }
    }

    @Override
    public R<String> enableUser(String id) {
        return userMapper.enableUser(id) == 1 ? R.success("解禁用户成功") : R.error("解禁用户失败");
    }

    @Override
    public R<String> logout(HttpSession session) {
        session.removeAttribute("userId");
        return R.success("退出成功");
    }
}
