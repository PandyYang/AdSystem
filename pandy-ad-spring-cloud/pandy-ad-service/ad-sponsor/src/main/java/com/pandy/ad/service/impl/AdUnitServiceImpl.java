package com.pandy.ad.service.impl;

import com.pandy.ad.constant.Constants;
import com.pandy.ad.dao.AdPlanRepository;
import com.pandy.ad.dao.AdUnitRepository;
import com.pandy.ad.entity.AdPlan;
import com.pandy.ad.entity.AdUnit;
import com.pandy.ad.exception.AdException;
import com.pandy.ad.service.IAdUnitService;
import com.pandy.ad.vo.AdUnitRequest;
import com.pandy.ad.vo.AdUnitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 16:31
 * @Version 1.0
 */
@Service
public class AdUnitServiceImpl implements IAdUnitService {

    @Autowired
    private AdPlanRepository adPlanRepository;
    @Autowired
    private AdUnitRepository adUnitRepository;

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {

        if (!request.createValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETER_ERROR);
        }

        Optional<AdPlan> adPlan = adPlanRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()){
            throw new AdException(Constants.ErrorMsg.USER_NOT_EXISTE);
        }

        AdUnit oldAdUnit = adUnitRepository.findByPlanIdAndUnitName(request.getPlanId(), request.getUnitName());
        if (oldAdUnit != null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }

        AdUnit newAdUnit = adUnitRepository.save(new AdUnit(request.getPlanId(),
                request.getUnitName(), request.getPositionType(),
                request.getBudget()));
        return new AdUnitResponse(newAdUnit.getId(),newAdUnit.getUnitName());
    }
}
