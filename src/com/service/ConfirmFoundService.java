package com.service;

import com.dao.ConfirmFoundDogDao;
import com.dao.GenericDao;
import com.dao.LostDogDao;
import com.entity.FoundDog;
import com.entity.LostDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SolarXu on 2017/7/16.
 */

@Service
@Transactional
public class ConfirmFoundService extends GenericDao<LostDog>
{
    @Autowired
    private ConfirmFoundDogDao confirmFoundDogDao;
    public void confirmFound(int lostDogId, int foundDogId)
    {
        confirmFoundDogDao.confirmFoundDog(lostDogId, foundDogId);
    }
}
