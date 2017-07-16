package com.dao;

import com.entity.FoundDog;
import com.entity.LostDog;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by FailureX on 2017/7/15.
 */
@Repository
public class GetFoundInfoByIdDao  extends GenericDao<FoundDog>
{
    public FoundDog getFoundInfoById(int id)
    {
        String jpql = "select m from FoundDog as m where m.id =:id";
        Query query = getEntityManager().createQuery(jpql).setParameter("id",id);
        Object result=query.getSingleResult();
        if(result==null){
            return null;
        }
        return (FoundDog)result;
    }
}
