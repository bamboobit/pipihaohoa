package com.pipihaohao.demo.repo.mysql;

import com.pipihaohao.demo.entity.mysql.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: xfh
 * @Date: 2019/5/8
 * @Description:
 */
public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {
    UserInfo finByEmail(String email);
}
