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
public class GetMyLostReleaseDao extends GenericDao<LostDog>
{
    public List<LostDog> getMyLostRelaseInfo(String username, int offset, int limit)
    {
        String jpql = "select m from LostDog as m where m.userName =:username order by m.id desc";
        Query query = getEntityManager().createQuery(jpql).setParameter("username",username);
        List<LostDog> list;
        if (limit > 0) {
            list = query
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        } else list = query.getResultList();
        return list;
    }
}
