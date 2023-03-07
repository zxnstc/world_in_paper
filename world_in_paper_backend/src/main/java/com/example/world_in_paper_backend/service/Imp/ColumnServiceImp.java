package com.example.world_in_paper_backend.service.Imp;

import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.bean.User;
import com.example.world_in_paper_backend.mapper.*;
import com.example.world_in_paper_backend.service.ColumnService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class ColumnServiceImp implements ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    @Autowired
    private ThumbMapper thumbMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavorMapper favorMapper;




    @Override
    public R<List<Map<String,Object>>> getAllColumns(String userId) {
        List<Map<String, Object>> allColumns = columnMapper.getAllColumns();
        if (allColumns != null) {
            for (Map<String, Object> column : allColumns) {
                String columnIdString = column.get("id").toString();
                Integer columnFavorCountByColumnId = columnMapper.getColumnFavorCountByColumnId(columnIdString);
                Integer columnArtCountByColumnId = columnMapper.getColumnArtCountByColumnId(columnIdString);
                column.put("column_favor_count", columnFavorCountByColumnId);
                column.put("column_art_count", columnArtCountByColumnId);
                if (userId != null) {
                    Integer columnFavorCountByColumnIdAndUserId = favorMapper.isFavor(Integer.valueOf(columnIdString), Integer.valueOf(userId),"0");
                    if (columnFavorCountByColumnIdAndUserId > 0) {
                        column.put("is_favor", true);
                    } else {
                        column.put("is_favor", false);
                    }
                }


            }
            return R.success(allColumns);

        }
        return R.success("暂无专栏");
    }

    @Override
    public R<List<Map<String,Object>>> getColumnLabels(Integer ColumnId) {
        return R.success(columnMapper.getColumnLabels(ColumnId));
    }

    @Override
    public R<List<Map<String, Object>>> getColumnArticles(Integer currentPage, Integer pageSize,Integer ColumnId, String userId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Map<String, Object>> articles = columnMapper.getColumnArticles(ColumnId);

        for (Map<String, Object> article : articles) {

            String articleIdString = article.get("id").toString();
            Integer isThumb = thumbMapper.isThumbs(Integer.parseInt(articleIdString),Integer.parseInt(userId),"2");
            article.put("is_thumb",isThumb);
            Integer thumbsCount = thumbMapper.getThumbsCountByTopicId(Integer.valueOf(articleIdString), "2");
            Integer commentCount = commentMapper.getCommentCountByTopicId(Integer.valueOf(articleIdString), "2");
            article.put("thumbs_count",thumbsCount);
            article.put("comment_count",commentCount);
            String content = article.get("content").toString();
            if (content.length() > 100) {
                content = parseHtml(content, 100);
            }else{
                content = parseHtml(content, content.length());
            }
            article.put("content",content);
            Integer creatorId = Integer.valueOf(article.get("creator_id").toString());
            User user = userMapper.getUserById(creatorId);
            user.setPassword("");
            article.put("creator",user);

            Date Time = (Date)article.get("create_time");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = sdf.format(Time);
            article.put("create_time",createTime);

        }
        return R.success(articles);
    }

    public static String parseHtml(String html,int length) {

        if(html == null || html.equals("")) {
            return html = "空";
        }else {
            if(html.length()<length){
                return html;
            }else {
                /*
                 * <.*?>为正则表达式，其中的.表示任意字符，*?表示出现0次或0次以上，此方法可以去掉双头标签(双头针对于残缺的标签)
                 * "<.*?"表示<尖括号后的所有字符，此方法可以去掉残缺的标签，及后面的内容
                 * " "，若有多种此种字符，可用同一方法去除
                 */
                html = html.replaceAll("<.*?>", " ").replaceAll("", "");
                html = html.replaceAll("<.*?", "");
                html = html.replaceAll("&nbsp;", "");
                return (html.substring(0, Math.min(html.length(), length)) + "...");
            }
        }
    }

    @Override
    public R<String> favorColumn(String columnId, String user_id) {
        favorMapper.addFavor(Integer.valueOf(columnId),Integer.valueOf(user_id),"0");
        return R.success("收藏成功");
    }

    @Override
    public R<String> addColumn(String userId,String title, String content,  String coverImg) {
        columnMapper.addColumn(Integer.valueOf(userId),title,content,coverImg);
        return R.success("添加成功");
    }

    @Override
    public R<Map<String, Object>> getColumn(String userId ,String columnId) {
        Map<String, Object> column = columnMapper.getColumn(columnId);
        if(column!=null){
            Date create_time = (Date) column.get("create_time");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            column.put("create_time",simpleDateFormat.format(create_time));
            Integer columnFavorCountByColumnId = columnMapper.getColumnFavorCountByColumnId(columnId);
            Integer columnArtCountByColumnId = columnMapper.getColumnArtCountByColumnId(columnId);
            column.put("column_favor_count",columnFavorCountByColumnId);
            column.put("column_art_count",columnArtCountByColumnId);
            Integer u= (Integer)column.get("creator_id");
            String columnIdString = column.get("id").toString();
            if (userId != null) {
                Integer columnFavorCountByColumnIdAndUserId = favorMapper.isFavor(Integer.valueOf(columnIdString), Integer.valueOf(userId),"0");
                if (columnFavorCountByColumnIdAndUserId > 0) {
                    column.put("is_favor", true);
                } else {
                    column.put("is_favor", false);
                }
            }
            if(u.equals(Integer.valueOf(userId))){
                column.put("is_creator",true);
            }else{
                column.put("is_creator",false);
            }
            return R.success(column);
        }else{
            return R.success("暂无专栏");
        }
    }

    @Override
    public R<String> notFavorColumn(String columnId, String userId) {
        favorMapper.deleteFavor(Integer.valueOf(columnId),Integer.valueOf(userId),"0");
        return R.success("取消收藏成功");
    }

    @Override
    public R<List<Map<String, Object>>> getColumnByUserId(String keyUserId) {
        List<Map<String, Object>> columns = columnMapper.getColumnByUserId(Integer.valueOf(keyUserId));
        for (Map<String, Object> column : columns) {
            String columnIdString = column.get("id").toString();
            Date create_time = (Date) column.get("create_time");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            column.put("create_time",simpleDateFormat.format(create_time));
            Integer columnFavorCountByColumnId = columnMapper.getColumnFavorCountByColumnId(columnIdString);
            Integer columnArtCountByColumnId = columnMapper.getColumnArtCountByColumnId(columnIdString);
            column.put("column_favor_count", columnFavorCountByColumnId);
            column.put("column_art_count", columnArtCountByColumnId);
        }
        return R.success(columns);
    }

    @Override
    public R<String> deleteColumn(String id) {
        //查看此专栏下是否有文章
        Integer count = columnMapper.getColumnArtCountByColumnId(id);
        if(count>0){
            return R.error("此专栏下有文章，无法删除");
        }else{
            columnMapper.deleteColumn(Integer.valueOf(id));
            return R.success("删除成功");
        }
    }
}
