package com.pandy.ad.service;

import com.pandy.ad.exception.AdException;
import com.pandy.ad.vo.CreateUserRequest;
import com.pandy.ad.vo.CreateUserResponse;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:17
 * @Version 1.0
 */
public interface IUserService {
    /**
     * 创建用户
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
