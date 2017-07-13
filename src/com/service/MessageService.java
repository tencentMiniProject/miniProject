package com.service;

/**
 * Created by william on 2017/7/12.
 */
import com.dao.MessageDao;
import com.entity.*;
import com.exception.PostException;
import com.util.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    //获取用户未读信息
    public String getMessage(String userName){
        List<Message> list = messageDao.getNewMessage(userName);
        List<JSONObject> jobjList = new ArrayList<JSONObject>();
        for(Message message : list){
            JSONObject jobj = new JSONObject();
            jobj.put("id", message.getId());
            jobj.put("title", message.getTitle());
            jobj.put("content", message.getContent());
            jobjList.add(jobj);
        }
        return JsonUtils.writeTableList((long)jobjList.size(), jobjList);
    }

    //标记已读
    public void markReadMessage(int id){
        messageDao.markReadMessage(id);
    }
}
