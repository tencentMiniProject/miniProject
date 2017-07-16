package com.service;

import com.dao.FoundDogDao;
import com.dao.GetMyFoundReleaseDao;
import com.dao.GetMyLostReleaseDao;
import com.entity.FoundDog;
import com.entity.LostDog;
import com.entity.Match_;
import com.util.JsonUtils;
import org.json.JSONArray;
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
public class GetMyReleaseService
{
    @Autowired
    private GetMyFoundReleaseDao getMyFoundReleaseDao;
    @Autowired
    private GetMyLostReleaseDao getMyLostReleaseDao;
    public String getMyLostReleaseInfo(String username, int offset, int limit)
    {
        List<LostDog> list = getMyLostReleaseDao.getMyLostRelaseInfo(username, offset, limit);
        List<JSONObject> jobjList = new ArrayList<JSONObject>();

        List<Integer> list_id=new ArrayList<>();
        for(LostDog lostDog : list) {
            list_id.add(lostDog.getId());
        }
//        JSONArray jsonArray=new JSONArray(list_id);
//        return jsonArray.toString();
        long total = list.size();
        return JsonUtils.writeTableList(total, list_id);
    }

    public String getMyFoundReleaseInfo(String username, int offset, int limit)
    {
        List<FoundDog> list = getMyFoundReleaseDao.getMyFoundRelaseInfo(username, offset, limit);
        List<JSONObject> jobjList = new ArrayList<JSONObject>();

        List<Integer> list_id=new ArrayList<>();
        for(FoundDog foundDog : list) {
            list_id.add(foundDog.getId());
        }
        //JSONArray jsonArray=new JSONArray(list_id);
        //return jsonArray.toString();
        long total = list.size();
        return JsonUtils.writeTableList(total, list_id);
    }


}