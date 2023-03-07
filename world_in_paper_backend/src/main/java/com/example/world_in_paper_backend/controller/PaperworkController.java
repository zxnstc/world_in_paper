package com.example.world_in_paper_backend.controller;

import com.example.world_in_paper_backend.annotation.LoginRequire;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.service.Imp.PaperworkServiceImp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

@RequestMapping("paperwork")
@RestController
public class PaperworkController {
    @Resource
    private PaperworkServiceImp paperworkServiceImp;

    @ApiOperation(value = "获取所有作品", notes = "获取所有作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页面", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true)
    })
    @GetMapping("getPaperwork")
    public R<ArrayList<Map<String, Object>>> getPaperwork(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return paperworkServiceImp.getPaperwork(currentPage, pageSize);
    }

    @ApiOperation(value = "上传作品", notes = "上传作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id"),
            @ApiImplicitParam(name = "title", value = "标题"),
            @ApiImplicitParam(name = "content", value = "内容"),
            @ApiImplicitParam(name = "imageUrl", value = "图片URL"),
            @ApiImplicitParam(name = "backgroundCustom", value = "自定义背景样式"),
            @ApiImplicitParam(name = "color", value = "颜色"),
            @ApiImplicitParam(name = "backgroundUrl", value = "自定义背景图片")
    })
    @PostMapping("uploadPaperwork")
    @LoginRequire
    public R<String> uploadPaperwork(@RequestParam("userId") Integer userId, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("imageUrl") String imageUrl, @RequestParam("backgroundCustom") String backgroundCustom, @RequestParam("color") String color, @RequestParam("backgroundUrl") String backgroundUrl) {
        return paperworkServiceImp.uploadPaperwork(userId, title, content, imageUrl, backgroundCustom, color, backgroundUrl);
    }

    @ApiOperation(value = "获取某个用户的所有作品", notes = "获取某个用户的所有作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id")
    })
    @GetMapping("getPaperworkByAuthorId")
    public R<ArrayList<Map<String, Object>>> getPaperworkByAuthorId(@RequestParam("id") String id) {
        return paperworkServiceImp.getPaperworkByAuthorId(id);
    }

    @ApiOperation(value = "获取某个作品", notes = "获取某个作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "作品id")
    })
    @GetMapping("getPaperworkById")
    public R<ArrayList<Map<String, Object>>> getPaperworkById(@RequestParam("id") String id) {
        return paperworkServiceImp.getPaperworkById(id);
    }

    @ApiOperation(value = "删除某个作品", notes = "删除某个作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "作品id")
    })
    @DeleteMapping("deletePaperworkById")
    public R<ArrayList<Map<String, Object>>> deletePaperworkById(@RequestParam("id") String id) {
        return paperworkServiceImp.deletePaperworkById(id);
    }
}
