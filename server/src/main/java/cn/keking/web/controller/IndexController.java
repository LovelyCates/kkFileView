package cn.keking.web.controller;

import cn.keking.newPro.entity.FileInfo;
import cn.keking.newPro.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  页面跳转
 * @author yudian-it
 * @date 2017/12/27
 */
@RestController
public class IndexController {

    @Autowired
    FileInfoService fileInfoService;

    @GetMapping( "/index")
    public String go2Index(){
        return "/main/index";
    }

    @GetMapping( "/record")
    public String go2Record(){
        return "/main/record";
    }

    @GetMapping( "/sponsor")
    public String go2Sponsor(){
        return "/main/sponsor";
    }

    @GetMapping( "/integrated")
    public String go2Integrated(){
        return "/main/integrated";
    }

    @GetMapping( "/")
    public String root() {
        return "/main/index";
    }

    @GetMapping("/fileInfo")
    public FileInfo getFileInfo() {
        return fileInfoService.getFileInfoById(1);
    }

}
