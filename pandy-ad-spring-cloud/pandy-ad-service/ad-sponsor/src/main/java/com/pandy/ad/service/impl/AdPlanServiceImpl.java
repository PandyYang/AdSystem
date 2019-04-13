package com.pandy.ad.service.impl;

import com.pandy.ad.constant.Constants;
import com.pandy.ad.dao.AdPlanRepository;
import com.pandy.ad.dao.AdUserRepository;
import com.pandy.ad.entity.AdPlan;
import com.pandy.ad.entity.AdUser;
import com.pandy.ad.exception.AdException;
import com.pandy.ad.service.IAdPlanService;
import com.pandy.ad.utils.CommonUtils;
import com.pandy.ad.vo.AdPlanGetRequest;
import com.pandy.ad.vo.AdPlanRequest;
import com.pandy.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 12:02
 * @Version 1.0
 */
@Service
public class AdPlanServiceImpl implements IAdPlanService {

    @Autowired
    private AdUserRepository adUserRepository;
    @Autowired
    private AdPlanRepository adPlanRepository;


    /**
     * 创建广告推广计划
     * @param request
     * @return
     * @throws AdException
     * 定义的请求和回应是对界面的
     */
    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {

        //请求参数不能为空
        if (!request.createValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETER_ERROR);
        }
        //确保关联的User是存在的
        Optional<AdUser> adUser = adUserRepository.findById(request.getId());
        if (!adUser.isPresent()){
            throw new AdException(Constants.ErrorMsg.USER_NOT_EXISTE);
        }
        //数据库已存在同名推广计划
        AdPlan oldPlan = adPlanRepository.findByUserIdAndPlanName(request.getUserId(), request.getPlanName());
        if (oldPlan!=null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_PLAV_ERROR);
        }
        //保存广告计划
        AdPlan newAdPlan = adPlanRepository.save(
                new AdPlan(request.getUserId(),request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate())
        ));
        //获取返回值
        return new AdPlanResponse(newAdPlan.getId(),
                newAdPlan.getPlanName());
    }

    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        return null;
    }

    @Override
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        return null;
    }

    @Override
    public void deleteAdPlan(AdPlanRequest request) throws AdException {

    }
}
