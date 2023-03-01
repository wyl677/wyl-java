package com.wyl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

/**
 * @auther yanl.wang
 * @date 2023/3/1
 **/
@Slf4j
@Controller
public class FileUpAndDownController {

    @PostMapping("/fileUp")
    public String upload(@RequestParam("files") MultipartFile[] files) throws IOException {
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String s = desktopDir.getAbsolutePath();//获取桌面路径



        if (files.length > 0){
            for (MultipartFile file : files) {
                if (!file.isEmpty()){
                    String originalFilename = file.getOriginalFilename();
                    file.transferTo(new File(s+File.separator+originalFilename));
                }
            }
        }
        return "success";
    }
}
