package com.dao;

import com.entity.FoundDog;
import com.entity.FoundDog;
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
 * Created by SolarXu on 2017/7/11
 */

@Repository
//获取数据库中丢失狗表
public class FoundDogDao extends GenericDao<FoundDog>
{
    public List<FoundDog> foundDogList(int offset, int limit)
    {
        String jpql = "SELECT e from FoundDog as e  order by e.id desc";
        Query query = getEntityManager().createQuery(jpql);
        List<FoundDog> list;
        if (limit > 0)
        {
            list = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        }
        else
            list = query.getResultList();
        return list;
    }

    @Transactional
    public FoundDog insertFoundDog(String username, String filePath, String content, String race, int age, String location, String nickName, String sex, String time)
    {
        FoundDog foundDog = new FoundDog();
        foundDog.setUserName(username);
        foundDog.setPicPath(filePath);
        foundDog.setRace(race);
        foundDog.setAge(age);
        foundDog.setLocation(location);
        foundDog.setContent(content);
        foundDog.setNickName(nickName);
        foundDog.setSex(sex);
        foundDog.setTime(time);

        persist(foundDog);
        refresh(foundDog);
        return foundDog;
    }
}