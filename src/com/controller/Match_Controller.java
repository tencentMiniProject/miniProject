package com.controller;

import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
/**
 * Created by william on 2017/7/13.
 */

@Controller
@RequestMapping("/matchInterface")
public class Match_Controller {
    @Autowired
    Match_Service match_Service;

    @ResponseBody
    @RequestMapping(value="/getMatchByUserName",produces = "application/json; charset=utf-8")
    public String getMatchByUserName(HttpSession session, String username, int offset, int limit){
        return match_Service.getMatchByUserName(username, offset, limit);
    }

    @ResponseBody
    @RequestMapping(value="/getMatchByLostDogId",produces = "application/json; charset=utf-8")
    public String getMatchByLostDogId(HttpSession session, int id, int offset, int limit){
        return match_Service.getMatchByLostDogId(id, offset, limit);
    }

    @ResponseBody
    @RequestMapping(value="/getMatchByFoundDogId",produces = "application/json; charset=utf-8")
    public String getMatchByFoundDogId(HttpSession session, int id, int offset, int limit){
        return match_Service.getMatchByFoundDogId(id, offset, limit);
    }

    @ResponseBody
    @RequestMapping(value="/getMatchInfo",produces = "application/json; charset=utf-8")
    public String getMatchInfo(int type, int id)
    {
        //返回信息
        return match_Service.getMatch(type, id);
    }
}
