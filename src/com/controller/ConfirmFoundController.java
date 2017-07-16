package com.controller;

import com.service.AddLostInfoService;
import com.service.ConfirmFoundService;
import com.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by SolarXu on 2017/7/16.
 */

@Controller
@RequestMapping("/confirmFound")
public class ConfirmFoundController
{
    @Autowired
    private ConfirmFoundService confirmFoundService;

    @ResponseBody
    @RequestMapping(value="/confirmFoundInfo",produces = "application/json; charset=utf-8")
    public String confirmFound(int lostDogId, int foundDogId)
    {
        confirmFoundService.confirmFound(lostDogId, foundDogId);
        return JsonUtils.writeStatus(1,"确认成功");
    }
}
