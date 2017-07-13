package com.dao;

import com.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
/**
 * Created by william on 2017/7/12.
 */
@Repository
public class MessageDao extends GenericDao<Message> {
    public List<Message> getNewMessage(String userName) {
        List<Message> ret;
        String jpql = "SELECT m from Message as m where m.userName =:userName and m.flag = true";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("userName", userName);
        ret = query.getResultList();
        return ret;
    }

    @Transactional
    public void markReadMessage(int id){
        String sql = "update message set flag = ? where id = ?";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1,false);
        query.setParameter(2, id);
        query.executeUpdate();
    }
}
