package com.example.ad.service;

import com.example.ad.exception.BusinessException;
import com.example.ad.vo.CreateUserRequest;
import com.example.ad.vo.CreateUserResponse;

public interface IUserService {
    /**
     * 创建用户
     * */
    CreateUserResponse createUser(CreateUserRequest request)
            throws BusinessException;
}
