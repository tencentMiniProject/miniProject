package com.dao;

import com.entity.FoundDog;
import com.entity.FoundDog;
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
 * Created by SolarXu on 2017/7/16.
 */

@Repository
public class ConfirmFoundDogDao  extends GenericDao<LostDog>
{
    public void confirmFoundDog(int lostDogId, int foundDogId)
    {
        String jpql = "SELECT e from LostDog as e where e.id=:lostDogId order by e.id desc";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("lostDogId", lostDogId);
        List<LostDog> list = query.getResultList();
        for(LostDog lostDog:list) {
            lostDog.setMatchedDogId(foundDogId);
        }
    }
}
