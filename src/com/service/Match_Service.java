package com.service;

import com.dao.Match_Dao;
import com.entity.*;
import com.util.JsonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by william on 2017/7/13.
 */

@Service
@Transactional
public class Match_Service {
    @Autowired
    private Match_Dao match_Dao;

    public String getMatchByUserName(String username, int offset, int limit){
        List<Match_> list = match_Dao.getMatchByUserName(username, offset, limit);
        List<JSONObject> jobjList = new ArrayList<JSONObject>();
        for(Match_ match : list) {
            JSONObject jobj = new JSONObject();
            jobj.put("match_id", match.getId());
            jobj.put("similarity",match.getSimilarity());
            jobj.put("lostDog_id",match.getLostDog().getId());
            jobj.put("lostDog_username",match.getLostDog().getUserName());
            jobj.put("lostDog_age",match.getLostDog().getAge());
            jobj.put("lostDog_content",match.getLostDog().getContent());
            jobj.put("lostDog_location",match.getLostDog().getLocation());
            jobj.put("lostDog_picPath",match.getLostDog().getPicPath());
            jobj.put("lostDog_race",match.getLostDog().getRace());
            jobj.put("foundDog_id",match.getFoundDog().getId());
            jobj.put("foundDog_age",match.getFoundDog().getAge());
            jobj.put("foundDog_content",match.getFoundDog().getContent());
            jobj.put("foundDog_location",match.getFoundDog().getLocation());
            jobj.put("foundDog_picPath",match.getFoundDog().getPicPath());
            jobj.put("foundDog_race",match.getFoundDog().getRace());
            jobj.put("foundDog_username",match.getFoundDog().getUserName());
            jobjList.add(jobj);
        }
        return JsonUtils.writeTableList(match_Dao.getTotalMatchByUserName(username), jobjList);
    }

    public String getMatchByLostDogId(int lostDogId, int offset, int limit){
        List<Match_> list = match_Dao.getMatchByLostDogId(lostDogId, offset, limit);
        List<JSONObject> jobjList = new ArrayList<JSONObject>();
        for(Match_ match : list){
            JSONObject jobj = new JSONObject();
            jobj.put("match_id", match.getId());
            jobj.put("similarity", match.getSimilarity());
            jobj.put("foundDog_id",match.getFoundDog().getId());
            jobj.put("foundDog_age",match.getFoundDog().getAge());
            jobj.put("foundDog_content",match.getFoundDog().getContent());
            jobj.put("foundDog_location",match.getFoundDog().getLocation());
            jobj.put("foundDog_picPath",match.getFoundDog().getPicPath());
            jobj.put("foundDog_race",match.getFoundDog().getRace());
            jobj.put("foundDog_username",match.getFoundDog().getUserName());
            jobjList.add(jobj);
        }
        JSONObject lostDogInfo = new JSONObject();
        if(list.size() > 0){
            Match_ m = list.get(0);
            lostDogInfo.put("lostDog_id", m.getLostDog().getId());
            lostDogInfo.put("lostDog_username",m.getLostDog().getUserName());
            lostDogInfo.put("lostDog_age",m.getLostDog().getAge());
            lostDogInfo.put("lostDog_content",m.getLostDog().getContent());
            lostDogInfo.put("lostDog_location",m.getLostDog().getLocation());
            lostDogInfo.put("lostDog_picPath",m.getLostDog().getPicPath());
            lostDogInfo.put("lostDog_race",m.getLostDog().getRace());
        }
        JSONObject ret = new JSONObject();
        ret.put("total", match_Dao.getTotalMatchByLostDogId(lostDogId));
        ret.put("lostDogInfo", lostDogInfo);
        ret.put("rows", jobjList);
        return ret.toString();
    }

    public String getMatchByFoundDogId(int foundDogId, int offset, int limit){
        List<Match_> list = match_Dao.getMatchByFoundDogId(foundDogId, offset, limit);
        List<JSONObject> jobjList = new ArrayList<JSONObject>();
        for(Match_ match : list){
            JSONObject jobj = new JSONObject();
            jobj.put("match_id", match.getId());
            jobj.put("similarity", match.getSimilarity());
            jobj.put("lostDog_id",match.getLostDog().getId());
            jobj.put("lostDog_age",match.getLostDog().getAge());
            jobj.put("lostDog_content",match.getLostDog().getContent());
            jobj.put("lostDog_location",match.getLostDog().getLocation());
            jobj.put("lostDog_picPath",match.getLostDog().getPicPath());
            jobj.put("lostDog_race",match.getLostDog().getRace());
            jobj.put("lostDog_username",match.getLostDog().getUserName());
            jobjList.add(jobj);
        }
        JSONObject foundDogInfo = new JSONObject();
        if(list.size() > 0){
            Match_ m = list.get(0);
            foundDogInfo.put("foundDog_id", m.getFoundDog().getId());
            foundDogInfo.put("foundDog_username",m.getFoundDog().getUserName());
            foundDogInfo.put("foundDog_age",m.getFoundDog().getAge());
            foundDogInfo.put("foundDog_content",m.getFoundDog().getContent());
            foundDogInfo.put("foundDog_location",m.getFoundDog().getLocation());
            foundDogInfo.put("foundDog_picPath",m.getFoundDog().getPicPath());
            foundDogInfo.put("foundDog_race",m.getFoundDog().getRace());
        }
        JSONObject ret = new JSONObject();
        ret.put("total", match_Dao.getTotalMatchByFoundDogId(foundDogId));
        ret.put("foundDogInfo", foundDogInfo);
        ret.put("rows", jobjList);
        return ret.toString();
    }

    public String getMatch(int type, int id)
    {
        if(type == 0)
        {
            return match_Dao.getLostMatch(id);
        }
        else
        {
            return match_Dao.getFoundMatch(id);
        }
    }
}
