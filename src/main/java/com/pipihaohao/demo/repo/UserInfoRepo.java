package com.pipihaohao.demo.repo;

import com.pipihaohao.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: xfh
 * @Date: 2019/5/8
 * @Description:
 */
public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {
}
