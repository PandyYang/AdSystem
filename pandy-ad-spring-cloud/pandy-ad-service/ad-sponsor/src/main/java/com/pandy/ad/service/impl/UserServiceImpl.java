package com.pandy.ad.service.impl;

import com.pandy.ad.constant.Constants;
import com.pandy.ad.dao.AdUserRepository;
import com.pandy.ad.entity.AdUser;
import com.pandy.ad.exception.AdException;
import com.pandy.ad.service.IUserService;
import com.pandy.ad.utils.CommonUtils;
import com.pandy.ad.vo.CreateUserRequest;
import com.pandy.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:22
 * @Version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository adUserRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository adUserRepository) {
        this.adUserRepository = adUserRepository;
    }

    @Transactional
    @Override
    public CreateUserResponse createUser(CreateUserRequest request)
                                        throws AdException {
        //请求信息不正确 用户名为空
        if (!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETER_ERROR);
        }
        AdUser oldUser = adUserRepository.findByUsername(request.getUsername());
        //数据库中有同名用户
        if (oldUser!=null){
            throw new AdException(Constants.ErrorMsg.USER_EXISTED_ERROR);
        }
        //为token加密
        AdUser newUser = adUserRepository.save(new AdUser(
                request.getUsername(),CommonUtils.md5(request.getUsername())
        ));
        return new CreateUserResponse(
                newUser.getId(),
                newUser.getUsername(),
                newUser.getToken(),
                newUser.getCreateTime(),
                newUser.getUpdateTime());
    }
}
