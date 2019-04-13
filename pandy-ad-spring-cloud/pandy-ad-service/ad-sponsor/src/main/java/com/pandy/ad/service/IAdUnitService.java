package com.pandy.ad.service;

import com.pandy.ad.exception.AdException;
import com.pandy.ad.vo.AdUnitRequest;
import com.pandy.ad.vo.AdUnitResponse;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 16:22
 * @Version 1.0
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;
}
