package com.controller;

import com.entity.Admin;
import com.exception.PostException;
import com.service.AddFoundInfoService;
import com.service.AddLostInfoService;
import com.service.ExamService;
import com.util.DateUtils;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SolarXu on 2017/7/11.
 */

@Controller
@RequestMapping("/addInfo/post")
public class AddInfo {

    @Autowired
    private AddLostInfoService addLostInfoService;
    @Autowired
    private AddFoundInfoService addFoundInfoService;

    @ResponseBody
    @RequestMapping(value="/addLostInfo",produces = "application/json; charset=utf-8")
    public String addLostInfo(String username, MultipartFile file, String content, String race, int age, String location)
    {
        //文件存储
        String fileName = file.getOriginalFilename();
        String pattern = "(.+)\\.(.+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(fileName);
        if(m.find())
        {
            String name = m.group(1);
            String fileSufix = m.group(2);
            fileName = name + String.valueOf(System.currentTimeMillis() + "." + fileSufix);
        }
        String rPath= "upload/LostDog/" + username + "/" + DateUtils.getTimeInMillis() +fileName;
        String path = System.getProperty("web.root") + rPath;
        File serviceFile=new File(path);
        if (!serviceFile.exists())
            serviceFile.mkdirs();
        try {
            file.transferTo(serviceFile);
        } catch (IOException e) {
            throw new PostException("上传失败，请重试！");
        }

        //更新表
        addLostInfoService.insertLostDog(username, path,content, race, age, location);
        return JsonUtils.writeStatus(1,"发布成功");
    }

    @ResponseBody
    @RequestMapping(value="/addFoundInfo",produces = "application/json; charset=utf-8")
    public String addFoundInfo(String username, MultipartFile file, String content, String race, int age, String location)
    {
        //文件存储
        String fileName = file.getOriginalFilename();
        String pattern = "(.+)\\.(.+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(fileName);
        if(m.find())
        {
            String name = m.group(1);
            String fileSufix = m.group(2);
            fileName = name + String.valueOf(System.currentTimeMillis() + "." + fileSufix);
        }
        String rPath= "upload/FoundDog/" + username + "/" + DateUtils.getTimeInMillis() +fileName;
        String path = System.getProperty("web.root") + rPath;
        File serviceFile=new File(path);
        if (!serviceFile.exists())
            serviceFile.mkdirs();
        try {
            file.transferTo(serviceFile);
        } catch (IOException e) {
            throw new PostException("上传失败，请重试！");
        }

        //更新表
        addFoundInfoService.insertFoundDog(username, path,content, race, age, location);
        return JsonUtils.writeStatus(1,"发布成功");
    }
}
