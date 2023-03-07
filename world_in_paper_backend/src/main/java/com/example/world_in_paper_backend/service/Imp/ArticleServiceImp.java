package com.example.world_in_paper_backend.service.Imp;

import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.mapper.ArticleMapper;
import com.example.world_in_paper_backend.mapper.ColumnMapper;
import com.example.world_in_paper_backend.mapper.UserMapper;
import com.example.world_in_paper_backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.example.world_in_paper_backend.service.Imp.ColumnServiceImp.parseHtml;

@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ColumnMapper columnMapper;

    @Resource
    private ThumbServiceImp thumbServiceImp;

    @Override
    public R<Map<String, Object>> getArticle(String articleId) {
        Map<String, Object> article = articleMapper.getArticleById(Integer.parseInt(articleId));
        if (article == null) {
            return R.error("文章不存在");
        }
        articleMapper.addVisitCount(Integer.parseInt(articleId));
        Date create_time = (Date) article.get("create_time");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        article.put("create_time", simpleDateFormat.format(create_time));
        Integer creatorId = (Integer) article.get("creator_id");
        User u = userMapper.getUserById(creatorId);
        article.put("creator", u);
        Integer column_id = (Integer) article.get("column_id");
        if (column_id != null) {
            article.put("column", columnMapper.getColumnTitleByColumnId(column_id));
        }

        return R.success(article);
    }

    @Override
    public R<String> addArticle(String title, String content, String creatorId, String columnId, String coverImg) {
        Integer i = articleMapper.addArticle(title, content, Integer.parseInt(creatorId), Integer.parseInt(columnId), coverImg);
        if (i == 1) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    @Override
    public R<List<Map<String, Object>>> getArticleByUserId(String keyUserId) {
        List<Map<String, Object>> articles = articleMapper.getArticleByUserId(Integer.parseInt(keyUserId));
        for (Map<String, Object> article : articles) {
            Integer articleId = (Integer) article.get("id");
            articleMapper.addVisitCount(articleId);
            Date create_time = (Date) article.get("create_time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            article.put("create_time", simpleDateFormat.format(create_time));
            String content = article.get("content").toString();
            if (content.length() > 100) {
                content = parseHtml(content, 100);
            } else {
                content = parseHtml(content, content.length());
            }
            article.put("content", content);
            Integer creatorId = (Integer) article.get("creator_id");
            User u = userMapper.getUserById(creatorId);
            article.put("creator", u);
            Integer column_id = (Integer) article.get("column_id");
            if (column_id != null) {
                article.put("column", columnMapper.getColumnTitleByColumnId(column_id));
            }
        }
        return R.success(articles);
    }

    @Override
    public R<String> deleteArticleById(String articleId) {
        Integer i = articleMapper.deleteArticleById(Integer.parseInt(articleId));
        if (i == 1) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R<String> thumbUpArticle(String articleId, String userId) {
        if(thumbServiceImp.isThumbs(articleId,userId,"2") == 0){
            Integer i = thumbServiceImp.addThumbs(articleId, userId, "2");
            if (i == 1) {
                return R.success("点赞成功");
            } else {
                return R.error("点赞失败");
            }
        }else{
            Integer i = thumbServiceImp.deleteThumbs(articleId, userId, "2");
            if (i == 1) {
                return R.success("取消点赞成功");
            } else {
                return R.error("取消点赞失败");
            }
        }
    }
}

