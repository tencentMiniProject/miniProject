package com.service;

import com.dao.GetAllFoundDogDao;
import com.dao.GetAllLostDogDao;
import com.dao.GetMyFoundReleaseDao;
import com.dao.GetMyLostReleaseDao;
import com.entity.FoundDog;
import com.entity.LostDog;
import com.util.JsonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SloarXu on 2017/7/16.
 */
@Service
@Transactional
public class GetAllDogService
{
    @Autowired
    public GetAllLostDogDao getAllLostDogDao;
    @Autowired
    private GetAllFoundDogDao getAllFoundDogDao;
    public String getAllLostDogInfo(int offset, int limit)
    {
        List<LostDog> list = getAllLostDogDao.getAllLostDog(offset, limit);
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

    public String getAllFoundDogInfo(int offset, int limit)
    {
        List<FoundDog> list = getAllFoundDogDao.getAllFoundDog(offset, limit);
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
