package com.dao;

import com.entity.FoundDog;
import com.entity.LostDog;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by SolarXu on 2017/7/15.
 */

@Repository
public class GetMyFoundReleaseDao extends GenericDao<FoundDog>
{
    public List<FoundDog> getMyFoundRelaseInfo(String username, int offset, int limit) {
        String jpql = "select m from FoundDog m where m.userName =:username order by m.id desc";
        Query query = getEntityManager().createQuery(jpql);
        List<FoundDog> list;
        if (limit > 0) {
            list = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        } else list = query.getResultList();
        return list;
    }
}

