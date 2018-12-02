package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 文件上传测试
 * @author: fxzhang
 * @Date: 2018/12/1 18:51
 */
@RestController
public class FileUploadController {

    @PostMapping("/file")
    public Map<String,String> uploadTest(MultipartFile fileName) throws IOException {
        System.out.println("已接收上传文件");
        System.out.println(fileName.getOriginalFilename());
        fileName.transferTo(new File("G:/"+fileName.getOriginalFilename()));
        System.out.println("文件上传成功");
        Map<String, String> map = new HashMap<>(1);
        map.put("OK","文件上传成功"+fileName.getOriginalFilename());
        return  map;
    }



}
