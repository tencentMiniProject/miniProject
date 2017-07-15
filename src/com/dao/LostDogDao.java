package com.dao;

import com.entity.LostDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by FailureX on 2017/7/11
 */

@Repository
//获取数据库中丢失狗表
public class LostDogDao extends GenericDao<LostDog> {
    public List<LostDog> lostDogList(int offset, int limit) {
        String jpql = "SELECT e from LostDog as e  order by e.id desc";
        Query query = getEntityManager().createQuery(jpql);
        List<LostDog> list;
        if (limit > 0) {
            list = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        } else list = query.getResultList();
        return list;
    }

    @Transactional
    public LostDog insertLostDog(String username, String filePath, String content, String race, int age, String location, String nickName, String sex, String time)
    {
        {
            LostDog lostDog = new LostDog();
            lostDog.setUserName(username);
            lostDog.setPicPath(filePath);
            lostDog.setRace(race);
            lostDog.setAge(age);
            lostDog.setLocation(location);
            lostDog.setContent(content);
            lostDog.setNickName(nickName);
            lostDog.setSex(sex);
            lostDog.setTime(time);


            persist(lostDog);
            refresh(lostDog);
            return lostDog;

        }
    }
}