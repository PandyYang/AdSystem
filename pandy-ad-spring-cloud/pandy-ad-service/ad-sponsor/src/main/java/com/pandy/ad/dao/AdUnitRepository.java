package com.pandy.ad.dao;

import com.pandy.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:01
 * @Version 1.0
 * 推广单元表
 */
public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {

    /**
     * 根据广告计划的id以及状态名称查询广告的状态
     * @param planId
     * @param unitName
     * @return
     */
    AdUnit findByPlanIdAndUnitName(Long planId,String unitName);

    /**
     * 根据推广单元的状态查询多个推广单元
     * @param unitStatus
     * @return
     */
    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}
