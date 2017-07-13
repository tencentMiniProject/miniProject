package com.service;

import com.dao.ExamDao;
import com.dao.FoundDogDao;
import com.dao.LostDogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SolarXu on 2017/7/11.
 */

@Service
@Transactional
public class AddFoundInfoService
{
    @Autowired
    private FoundDogDao foundDogDao;

    public void insertFoundDog(String username, String filePath,String content, String race, int age, String location)
    {
        foundDogDao.insertFoundDog(username, filePath,content, race, age, location);
    }
}