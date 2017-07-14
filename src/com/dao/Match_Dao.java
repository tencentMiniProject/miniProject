package com.dao;

import com.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
/**
 * Created by william on 2017/7/13.
 */

@Repository
public class Match_Dao extends GenericDao<Match_>{
    public List<Match_> getMatchByUserName(String username, int offset, int limit) {
        List<Match_> ret;
        String jpql = "select m from Match_ m where m.lostDog.userName =:username order by m.similarity desc";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("username", username);
        if(limit > 0){
            ret = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        }else{
            ret = query.getResultList();
        }
        return ret;
    }

    public long getTotalMatchByUserName(String username){
        String jpql = "select count(m) from Match_ m where m.lostDog.userName =:username";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("username", username);
        return (long)query.getSingleResult();
    }

    public List<Match_> getMatchByLostDogId(int lostDogId, int offset, int limit){
        List<Match_> ret;
        String jpql = "select m from Match_ m where m.lostDog.id =:lostDogId order by m.similarity desc";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("lostDogId", lostDogId);
        if(limit > 0){
            ret = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        }else{
            ret = query.getResultList();
        }
        return ret;
    }

    public long getTotalMatchByLostDogId(int lostDogId){
        String jpql = "select count(m) from Match_ m where m.lostDog.id =:lostDogId";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("lostDogId", lostDogId);
        return (long)query.getSingleResult();
    }

    public List<Match_> getMatchByFoundDogId(int foundDogId, int offset, int limit){
        List<Match_> ret;
        String jpql = "select m from Match_ m where m.foundDog.id =:foundDogId order by m.similarity desc";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("foundDogId", foundDogId);
        if(limit > 0){
            ret = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        }else{
            ret = query.getResultList();
        }
        return ret;
    }

    public long getTotalMatchByFoundDogId(int foundDogId){
        String jpql = "select count(m) from Match_ m where m.foundDog.id =:foundDogId";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("foundDogId", foundDogId);
        return (long)query.getSingleResult();
    }
}
