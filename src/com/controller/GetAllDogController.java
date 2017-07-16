package com.controller;

import com.service.AddLostInfoService;
import com.service.GetAllDogService;
import com.service.GetMyReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by SloarXu on 2017/7/16.
 */

@Controller
@RequestMapping("/getAllDog")
public class GetAllDogController
{
    @Autowired
    private GetAllDogService getAllDogService;

    @ResponseBody
    @RequestMapping(value="/getAllDogInfo",produces = "application/json; charset=utf-8")
    public String getAllLostDogInfo(String type, int offset, int limit)
    {
        if(Integer.parseInt(type) == 0)
        {
            return getAllDogService.getAllLostDogInfo(offset, limit);
        }
        else
        {
            return getAllDogService.getAllFoundDogInfo(offset, limit);
        }
    }
}
