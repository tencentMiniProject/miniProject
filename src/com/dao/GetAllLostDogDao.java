package com.dao;

import com.entity.FoundDog;
import com.entity.LostDog;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by SloarXu on 2017/7/16.
 */
@Repository
public class GetAllLostDogDao extends GenericDao<LostDog>
{
    public List<LostDog> getAllLostDog(int offset, int limit) {
        String jpql = "select m from LostDog m order by m.id desc";
        Query query = getEntityManager().createQuery(jpql);
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
