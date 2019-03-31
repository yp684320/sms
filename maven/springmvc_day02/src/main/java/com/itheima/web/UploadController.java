package com.itheima.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

//文件上传
@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile myFile , HttpServletRequest request) throws IOException {
        //获取文件名称
        String filename = myFile.getOriginalFilename();
       filename = UUID.randomUUID().toString().replace("-","")+filename;
        //获取当前项目在磁盘的根路径
        ServletContext servletContext = request.getSession().getServletContext();
        String path = servletContext.getRealPath("");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        path = path+"upload\\"+date;
        //创建文件夹
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
         //上传资源
        File file1 = new File(file, filename);
        myFile.transferTo(file1);

        return "success";
    }

}
