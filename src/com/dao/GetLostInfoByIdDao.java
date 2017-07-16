package com.dao;

import com.entity.LostDog;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by SolarXu on 2017/7/15.
 */
@Repository
public class GetLostInfoByIdDao extends GenericDao<LostDog>
{
    public LostDog getLostInfoById(int id)
    {
        String jpql = "select m from LostDog as m where m.id =:id";
        Query query = getEntityManager().createQuery(jpql).setParameter("id",id);
        Object result=query.getSingleResult();
        if(result==null){
            return null;
        }
        return (LostDog)result;
    }
}
