package com.controller;

import com.exception.PostException;
import com.service.AddFoundInfoService;
import com.service.AddLostInfoService;
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
        String[] tmps = fileName.split("\\.");
        if(tmps.length==0) throw new PostException("请传入正确的文件格式");
        String fileExt = tmps[tmps.length-1];
        fileName = DateUtils.getTimeInMillis() + "." + fileExt;
        String path= "/upload/LostDog/" + username + "/" + DateUtils.getTimeInMillis() +fileName;
        String sPath = System.getProperty("web.root") + path;
        File serviceFile=new File(sPath);
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
        String[] tmps = fileName.split("\\.");
        if(tmps.length==0) throw new PostException("请传入正确的文件格式");
        String fileExt = tmps[tmps.length-1];
        fileName = DateUtils.getTimeInMillis() + "." + fileExt;
        String path= "upload/FoundDog/" + username + "/" + DateUtils.getTimeInMillis() +fileName;
        String sPath = System.getProperty("web.root") + path;
        File serviceFile=new File(sPath);
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
