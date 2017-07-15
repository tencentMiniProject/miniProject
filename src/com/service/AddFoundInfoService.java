package com.service;

import com.dao.FoundDogDao;
import com.dao.LostDogDao;
import com.exception.PostException;
import com.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by SolarXu on 2017/7/11.
 */

@Service
@Transactional
public class AddFoundInfoService
{
    @Autowired
    private FoundDogDao foundDogDao;

    public void insertFoundDog(String username, MultipartFile file, String content, String race, int age, String location, String nickName, String sex, String time)
    {
        //文件存储
        String fileName = file.getOriginalFilename();
        String[] tmps = fileName.split("\\.");
        if(tmps.length==0) throw new PostException("请传入正确的文件格式");
        String fileExt = tmps[tmps.length-1];
        fileName = DateUtils.getTimeInMillis() + "." + fileExt;
        String path= "upload/FoundDog/" + username + "/" + DateUtils.getTimeInMillis() +fileName;
        String sPath = System.getProperty("web.root") + path;
        File serviceFile=new File(sPath);
        if (!serviceFile.exists())
            serviceFile.mkdirs();
        try {
            file.transferTo(serviceFile);
        } catch (IOException e) {
            throw new PostException("上传失败，请重试！");
        }
        foundDogDao.insertFoundDog(username, path, content, race, age, location, nickName, sex, time);
    }
}