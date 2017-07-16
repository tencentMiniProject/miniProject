package com.dao;

import com.entity.*;
import com.util.JsonUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
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

    public String getLostMatch(int id) {
        List<Match_> ret;
        String jpql = "SELECT m from Match_ m where m.lostDog.id =:id";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("id", id);
        ret = query.getResultList();


        List<JSONObject> jobjList = new ArrayList<JSONObject>();
        for(Match_ match_degree:ret)
        {
            JSONObject jobj = new JSONObject();
            jobj.put("id", match_degree.getFoundDog().getId());
            jobj.put("match", match_degree.getSimilarity());
            jobjList.add(jobj);
        }
        return JsonUtils.writeTableList((long)jobjList.size(), jobjList);
    }

    public String getFoundMatch(int id) {
        List<Match_> ret;
        String jpql = "SELECT m from Match_ m where m.foundDog.id =:id";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("id", id);
        ret = query.getResultList();


        List<JSONObject> jobjList = new ArrayList<JSONObject>();
        for(Match_ match_degree:ret)
        {
            JSONObject jobj = new JSONObject();
            jobj.put("id", match_degree.getLostDog().getId());
            jobj.put("match", match_degree.getSimilarity());
            jobjList.add(jobj);
        }
        return JsonUtils.writeTableList((long)jobjList.size(), jobjList);
    }
}
