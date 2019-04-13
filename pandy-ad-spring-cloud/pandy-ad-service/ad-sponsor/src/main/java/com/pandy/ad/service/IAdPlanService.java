package com.pandy.ad.service;

import com.pandy.ad.entity.AdPlan;
import com.pandy.ad.exception.AdException;
import com.pandy.ad.vo.AdPlanGetRequest;
import com.pandy.ad.vo.AdPlanRequest;
import com.pandy.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:39
 * @Version 1.0
 */
public interface IAdPlanService {
    /**
     * 创建推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
