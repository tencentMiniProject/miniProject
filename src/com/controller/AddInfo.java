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
    public String addLostInfo(String username, MultipartFile file, String content, String race, int age, String location, String nickName, String sex, String time)
    {

        //更新表
        addLostInfoService.insertLostDog(username, file, content, race, age, location, nickName, sex, time);
        return JsonUtils.writeStatus(1,"发布成功");
    }

    @ResponseBody
    @RequestMapping(value="/addFoundInfo",produces = "application/json; charset=utf-8")
    public String addFoundInfo(String username, MultipartFile file, String content, String race, int age, String location, String nickName, String sex, String time)
    {

        //更新表
        addFoundInfoService.insertFoundDog(username, file,content, race, age, location, nickName, sex, time);
        return JsonUtils.writeStatus(1,"发布成功");
    }
}
