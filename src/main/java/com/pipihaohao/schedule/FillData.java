package com.pipihaohao.schedule;

import com.pipihaohao.demo.entity.mysql.UserInfo;
import com.pipihaohao.demo.repo.mysql.UserInfoRepo;
import com.pipihaohao.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Random;

/**
 * @description:
 * @author: xfh
 * @create: 2019-08-06 18:07
 **/

@Service
@Slf4j
public class FillData {

    @Autowired
    private UserService userService;
    @Autowired
    UserInfoRepo userInfoRepo;

    @Scheduled(cron = "0/1 * * * * ?")
    public synchronized void fillData(){
        for(int i = 1;i<=10;i++){
            Random random = new Random();
            UserInfo userInfo = userInfoRepo.findById(i).get();
            userInfo.setName(RandomStringUtils.randomAlphanumeric(random.nextInt(15)));
            userInfo.setEmail(RandomStringUtils.randomAlphanumeric(random.nextInt(15))+"@"+RandomStringUtils.randomAlphanumeric(random.nextInt(4))+".com");
            userInfo.setPassword(RandomStringUtils.randomAlphanumeric(random.nextInt(8)));
            userInfo.setAge(random.nextInt(90));
            userInfo.setPhone(getRandomString(11));
            userInfo.setCreateAt(Timestamp.valueOf(Long.valueOf(System.currentTimeMillis()/1000).toString()));
            userInfo.setUpdateAt(Timestamp.valueOf(Long.valueOf(System.currentTimeMillis()/1000).toString()));
            userInfoRepo.save(userInfo);
            log.info("save userInfo={]",userInfo);
        }
    }

    public static String getRandomString(int length){
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
