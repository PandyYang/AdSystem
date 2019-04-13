package com.pandy.ad.dao;

import com.pandy.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:49
 * @Version 1.0
 * 用户表
 */
public interface AdUserRepository extends JpaRepository<AdUser,Long> {
    /**
     * 根据用户名查找用户记录
     * @param username
     * @return
     */
    AdUser findByUsername(String username);


}
