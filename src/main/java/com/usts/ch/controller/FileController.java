package com.usts.ch.controller;

import com.usts.ch.utils.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    @CrossOrigin
    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
//        String folder = "/Campus_help/workspace/img";
        String folder = "/www/server/nginx/html/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(8) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf(".")));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
//            String imgURL = "http://kdcnxx.cn/api/file/" + f.getName();
            String imgURL = "http://www.kdcnxx.cn/img/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
