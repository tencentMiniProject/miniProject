package com.controller;

import com.service.AddLostInfoService;
import com.service.GetMyReleaseService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by SolarXu on 2017/7/15.
 */
@Controller
@RequestMapping("/getMyRelease")
public class GetMyReleaseController
{
    @Autowired
    private GetMyReleaseService getMyReleaseInfo;
    @ResponseBody
    @RequestMapping(value="/getMyReleaseInfo",produces = "application/json; charset=utf-8")
    public String getMyReleaseInfo(String username, String type, String offset, String limit)
    {
        System.out.println();
        System.out.println(username+" "+type+" "+offset+" "+limit);
        if(Integer.parseInt(type) == 0)
        {
            return getMyReleaseInfo.getMyLostReleaseInfo(username, Integer.parseInt(offset), Integer.parseInt(limit));
        }
        else
        {
            return getMyReleaseInfo.getMyFoundReleaseInfo(username, Integer.parseInt(offset), Integer.parseInt(limit));
        }
    }
}
