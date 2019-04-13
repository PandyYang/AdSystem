package com.pandy.ad.service.impl;

import com.pandy.ad.constant.CommonStatus;
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

import java.util.Date;
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

    /**
     * 根据id查询广告计划
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {

        if (!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETER_ERROR);
        }

        return adPlanRepository.findAllByIdInAndUserId(request.getIds(),request.getUserId());
    }

    /**
     * 修改广告计划
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {

        //如果不能通过验证 证明有空值 无法对请求进行更新
        if (!request.updateValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETER_ERROR);
        }
        //如果查询不到用户 无法完成对不存在的数据的更新
        AdPlan oldId = adPlanRepository.findByIdAndUserId(request.getId(), request.getUserId());
        if (oldId == null){
            throw new AdException(Constants.ErrorMsg.USER_NOT_EXISTE);
        }
        //检验计划名称非空 构造器要求传入四个参数 但是更新时不是必传参数
        if (request.getPlanName()!=null){
            oldId.setPlanName(request.getPlanName());
        }
        //检验开始日期非空 非空才对字段修改
        if (request.getStartDate()!=null){
            oldId.setStartDate(CommonUtils.parseStringDate(request.getStartDate()));
        }
        //检验结束日期非空
        if (request.getEndDate()!=null){
            oldId.setEndDate(CommonUtils.parseStringDate(request.getEndDate()));
        }
        oldId.setUpdateTime(new Date());
        oldId = adPlanRepository.save(oldId);

        return new AdPlanResponse(request.getId(),request.getPlanName());
    }

    /**
     * 删除广告计划
     * @param request
     * @throws AdException
     */
    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {
        if (!request.deleteValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETER_ERROR);
        }
        AdPlan plan = adPlanRepository.findByIdAndUserId(request.getId(), request.getUserId());
        if (plan == null){
            throw new AdException(Constants.ErrorMsg.USER_NOT_EXISTE);
        }
        //采用逻辑删除
        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());
    }
}
