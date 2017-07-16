package com.service;

import com.dao.GetFoundInfoByIdDao;
import com.dao.GetLostInfoByIdDao;
import com.dao.GetMyFoundReleaseDao;
import com.dao.GetMyLostReleaseDao;
import com.entity.FoundDog;
import com.entity.LostDog;
import com.entity.Match_;
import com.util.JsonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SolarXu on 2017/7/15.
 */

@Service
@Transactional
public class GetInfoByIdService
{
    @Autowired
    private GetFoundInfoByIdDao getFoundInfoByIdDao;
    @Autowired
    private GetLostInfoByIdDao getLostInfoByIdDao;

    public String getFoundInfoById(int id)
    {
        FoundDog foundDog = getFoundInfoByIdDao.getFoundInfoById(id);

        JSONObject jobj = new JSONObject();
        jobj.put("id", foundDog.getId());
        jobj.put("userName",foundDog.getUserName());
        jobj.put("picPath",foundDog.getPicPath());
        jobj.put("content",foundDog.getContent());
        jobj.put("race",foundDog.getRace());
        jobj.put("age",foundDog.getAge());
        jobj.put("location",foundDog.getLocation());
        jobj.put("sex",foundDog.getSex());
        jobj.put("nickName",foundDog.getNickName());
        jobj.put("sex",foundDog.getSex());
        jobj.put("time",foundDog.getTime());

        return jobj.toString();
    }

    public String getLostInfoById(int id)
    {
        LostDog lostDog = getLostInfoByIdDao.getLostInfoById(id);
        JSONObject jobj=new JSONObject();

        jobj.put("id", lostDog.getId());
        jobj.put("userName",lostDog.getUserName());
        jobj.put("picPath",lostDog.getPicPath());
        jobj.put("content",lostDog.getContent());
        jobj.put("race",lostDog.getRace());
        jobj.put("age",lostDog.getAge());
        jobj.put("location",lostDog.getLocation());
        jobj.put("sex",lostDog.getSex());
        jobj.put("nickName",lostDog.getNickName());
        jobj.put("sex",lostDog.getSex());
        jobj.put("time",lostDog.getTime());

        return jobj.toString();
    }
}
