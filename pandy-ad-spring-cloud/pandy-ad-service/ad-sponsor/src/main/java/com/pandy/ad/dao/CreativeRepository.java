package com.pandy.ad.dao;

import com.pandy.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:06
 * @Version 1.0
 * 创意表
 */
public interface CreativeRepository extends JpaRepository<Creative,Long> {

}
