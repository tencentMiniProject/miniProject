package com.timer;


import com.dao.Match_Dao;
import com.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
@Lazy(value=false)
public class Timer {
    @Autowired
    private Match_Dao matchDao;

    @Scheduled(cron = "*/2 * * * * ?")
    public void sendMesssage() {
        System.out.print("近期监考");
        Date date = DateUtils.getTomorrowDate();
        //List<Exam> list = examDao.examListOfOneDay(date);

    }
}

