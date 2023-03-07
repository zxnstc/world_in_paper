package com.example.world_in_paper_backend.service;

import com.example.world_in_paper_backend.bean.R;

import java.util.ArrayList;
import java.util.Map;

public interface PaperworkService {
    public R<ArrayList<Map<String, Object>>> getPaperwork(Integer currentPage,Integer pageSize);

    public R<String> uploadPaperwork(Integer userId,String title,String content,String imageUrl,String backgroundCustom,String color,String backgroundUrl);

    public R<ArrayList<Map<String, Object>>> getPaperworkByAuthorId(String id);

    public R<ArrayList<Map<String, Object>>> getPaperworkById(String id);

    public R<ArrayList<Map<String, Object>>> deletePaperworkById(String id);
}
