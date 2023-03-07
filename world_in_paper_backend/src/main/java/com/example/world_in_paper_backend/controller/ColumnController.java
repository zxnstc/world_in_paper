package com.example.world_in_paper_backend.controller;


import com.example.world_in_paper_backend.annotation.LoginRequire;
import com.example.world_in_paper_backend.bean.R;
import com.example.world_in_paper_backend.service.Imp.ColumnServiceImp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/column")
public class ColumnController {
    @Autowired
    private ColumnServiceImp columnServiceImp;

    @ApiOperation(value = "获取专栏", notes = "获取专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "columnId", value = "栏目的id", required = true),
            @ApiImplicitParam(name = "userId", value = "用户的id", required = true),
    })
    @GetMapping("/getColumn")
    public R<Map<String, Object>> getColumn(@RequestParam String userId,@RequestParam String columnId) {
        return columnServiceImp.getColumn(userId,columnId);
    }

    @ApiOperation(value = "获取所有的专栏", notes = "获取所有的专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户的id", required = true),
    })
    @GetMapping("/getAllColumns")
    public R<List<Map<String, Object>>> getAllColumns( @RequestParam String userId) {

        return columnServiceImp.getAllColumns(userId);
    }

    @ApiOperation(value = "获取专栏的文章的标签", notes = "获取专栏的文章的标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "columnId", value = "专栏的id", required = true),

    })
    @GetMapping("/getColumnLabels")
    public R<List<Map<String,Object>>> getColumnLabels(@RequestParam String columnId){
        return columnServiceImp.getColumnLabels(Integer.parseInt(columnId));

    }

    @ApiOperation(value = "获取专栏的文章", notes = "获取专栏的文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "columnId", value = "专栏的id", required = true),
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true),
            @ApiImplicitParam(name = "userId", value = "用户的id", required = true),
    })
    @GetMapping("/getColumnArticles")
    public R<List<Map<String,Object>>> getColumnArticles(@RequestParam Integer currentPage,@RequestParam Integer pageSize,@RequestParam String columnId,@RequestParam String userId){
        return columnServiceImp.getColumnArticles(currentPage,pageSize,Integer.parseInt(columnId),userId);
    }


    @ApiOperation(value = "关注专栏", notes = "关注专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "columnId", value = "专栏的id", required = true),
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true)
    })
    @PostMapping("/favorColumn")
    public R<String> favorColumn(@RequestParam String columnId,@RequestParam String userId){
        return columnServiceImp.favorColumn(columnId,userId);
    }
    @ApiOperation(value = "取消关注专栏", notes = "取消关注专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "columnId", value = "专栏的id", required = true),
            @ApiImplicitParam(name = "userId", value = "用户Id", required = true)
    })
    @PostMapping("/notFavorColumn")
    @LoginRequire
    public R<String> notFavorColumn(@RequestParam String columnId,@RequestParam String userId){
        return columnServiceImp.notFavorColumn(columnId,userId);
    }

    @ApiOperation(value = "添加专栏", notes = "添加专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户的id", required = true),
            @ApiImplicitParam(name = "title", value = "专栏的标题", required = true),
            @ApiImplicitParam(name = "content", value = "专栏的内容", required = true),
            @ApiImplicitParam(name = "coverImg", value = "封面图片", required = true),
    })
    @PostMapping("/addColumn")
    @LoginRequire
    public R<String> addColumn(@RequestParam String userId,@RequestParam String title,@RequestParam String content,@RequestParam String coverImg){
        return columnServiceImp.addColumn(userId,title,content,coverImg);
    }

    @ApiOperation(value = "根据userId获取专栏", notes = "获取userId专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyUserId", value = "目的Userid", required = true)
    })
    @GetMapping("/getColumnByUserId")
    public R<List<Map<String,Object>>> getColumnByUserId(@RequestParam String keyUserId){
        return columnServiceImp.getColumnByUserId(keyUserId);
    }

    @ApiOperation(value = "删除专栏", notes = "删除专栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "专栏的id", required = true)
    })
    @PostMapping("/deleteColumn")
    @LoginRequire
    public R<String> deleteColumn(@RequestParam String id){
        return columnServiceImp.deleteColumn(id);
    }




}
