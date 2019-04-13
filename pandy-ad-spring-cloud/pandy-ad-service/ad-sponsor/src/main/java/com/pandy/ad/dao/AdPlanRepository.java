package com.pandy.ad.dao;

import com.pandy.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:54
 * @Version 1.0
 * 推广计划表
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {

    /**
     * 根据广告计划的id以及userid查询广告计划
     * @param id
     * @param userId
     * @return
     */
    AdPlan findByIdAndUserId(Long id,Long userId);

    /**
     * 根据多个广告计划的ids与userid查询多个广告计划
     * @param ids
     * @param userId
     * @return
     */
    List<AdPlan> findAllByIdInAndUserId(List<Long> ids,Long userId);

    /**
     * 根据uderid和广告计划名称查询对应的广告计划
     * @param userId
     * @param planName
     * @return
     */
    AdPlan findByUserIdAndPlanName(Long userId,String planName);

    /**
     * 根据计划状态查询所有的广告计划
     * @param status
     * @return
     */
    List<AdPlan> findAllByPlanStatus(Integer status);
}
