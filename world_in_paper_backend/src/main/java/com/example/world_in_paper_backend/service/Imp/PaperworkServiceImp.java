package com.example.world_in_paper_backend.service.Imp;


import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.mapper.PaperworkMapper;
import com.example.world_in_paper_backend.service.PaperworkService;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaperworkServiceImp implements PaperworkService {

    @Resource
    private PaperworkMapper paperworkMapper;

    @Override
    public R<ArrayList<Map<String, Object>>> getPaperwork(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        ArrayList<Map<String, Object>> mapArrayList = paperworkMapper.getPaperwork();
        for (Map<String, Object> map : mapArrayList) {
            Date date = (Date) map.get("create_time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            map.put("create_time", format);
        }
        return R.success(mapArrayList);
    }

    @Override
    public R<String> uploadPaperwork(Integer authorId, String title, String content, String imageUrl, String backgroundCustom, String color, String backgroundUrl) {
        try {
            switch (backgroundCustom) {
                case "default":
                    paperworkMapper.uploadPaperwork(title, authorId, content, imageUrl);
                    break;
                case "color":
                    paperworkMapper.uploadPaperworkWithColor(title, authorId, content, imageUrl, color);
                    break;
                case "image":
                    paperworkMapper.uploadPaperworkWithImage(title, authorId, content, imageUrl, backgroundUrl);
                    break;
            }
            return R.success("上传成功");
        } catch (Exception e) {
            return R.error("上传失败");
        }
    }

    @Override
    public R<ArrayList<Map<String, Object>>> getPaperworkByAuthorId(String id) {
        Integer intid = Integer.parseInt(id);
        ArrayList<Map<String, Object>> mapArrayList = paperworkMapper.getPaperworkByAuthorId(intid);
        for (Map<String, Object> map : mapArrayList) {
            Date date = (Date) map.get("create_time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(date);
            map.put("create_time", format);
        }
        return R.success(mapArrayList);
    }

    @Override
    public R<ArrayList<Map<String, Object>>> getPaperworkById(String id) {
        Integer intid = Integer.parseInt(id);
        ArrayList<Map<String, Object>> mapArrayList = paperworkMapper.getPaperworkById(intid);
        for (Map<String, Object> map : mapArrayList) {
            Date date = (Date) map.get("create_time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(date);
            map.put("create_time", format);
        }
        return R.success(mapArrayList);
    }

    @Override
    public R<ArrayList<Map<String, Object>>> deletePaperworkById(String id) {
        Integer intid = Integer.parseInt(id);
        try {
            paperworkMapper.deletePaperworkById(intid);
            return R.success("删除成功");
        } catch (Exception e) {
            return R.error("删除失败");
        }
    }
}
