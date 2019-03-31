package com.itheima.web;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
   /* @ModelAttribute
    public User aa(int id,String username){
        //根据id查询
        User user = findById(id);
        //查询出来的
        System.out.println(user);
        user.setUsername(username);
        System.out.println(user);
        return user;
    }*/

    @ModelAttribute
    public void aa(int id,String password,Map<String ,User> map){
        //根据id查询
        User user = findById(id);
        //查询出来的
        System.out.println(user);
        user.setPassword(password);
        System.out.println(user);
        map.put("asd",user);

    }
    @RequestMapping("/params")
    public String params(@ModelAttribute(value = "asd") User user){
        System.out.println(user);
        return "success";

    }
    public User findById(int id){
        User user = new User();
        user.setId(11);
        user.setUsername("李华");
        user.setPassword("123");
        return user;
    }
    @RequestMapping("/upload")
    public String upload(MultipartFile myFile , HttpServletRequest request) throws IOException {
        //获取文件名称
        String filename = myFile.getOriginalFilename();
        filename = UUID.randomUUID().toString().replace("-", "") + filename;
         //获取当前项目在磁盘上的根路径
        ServletContext servletContext = request.getSession().getServletContext();
        String path = servletContext.getRealPath("");
        System.out.println(path);
         String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        path = path+"upload\\"+date;
       System.out.println(date);
        //创建文件夹
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //传递资源
        File file1 = new File(file,filename);
        myFile.transferTo(file1);
        return "success";
    }


}
