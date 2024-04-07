package com.github.ad.service;

import com.github.ad.exception.BusinessException;
import com.github.ad.vo.CreateUserRequest;
import com.github.ad.vo.CreateUserResponse;

public interface IUserService {
    /**
     * 创建用户
     * */
    CreateUserResponse createUser(CreateUserRequest request)
            throws BusinessException;
}
