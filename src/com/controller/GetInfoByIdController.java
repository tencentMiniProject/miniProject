package com.controller;

import com.service.GetInfoByIdService;
import com.service.GetMyReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by SolarXu on 2017/7/15.
 */

@Controller
@RequestMapping("/getInfo")
public class GetInfoByIdController
{
    @Autowired
    private GetInfoByIdService getInfoByIdService;
    @ResponseBody
    @RequestMapping(value="/getInfoById",produces = "application/json; charset=utf-8")

    public String getInfoById(String username, String id, String type)
    {
        if(Integer.parseInt(type) == 0)
        {
            return getInfoByIdService.getLostInfoById(Integer.parseInt(id));
        }
        else
        {
            return getInfoByIdService.getFoundInfoById(Integer.parseInt(id));
        }

    }
}
