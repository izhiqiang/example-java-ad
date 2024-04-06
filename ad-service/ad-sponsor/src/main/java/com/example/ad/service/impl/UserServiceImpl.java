package com.example.ad.service.impl;

import com.example.ad.dao.AdUserRepository;
import com.example.ad.entity.AdUser;
import com.example.ad.exception.CommonException;
import com.example.ad.service.IUserService;
import com.example.ad.utils.CommonUtils;
import com.example.ad.vo.CreateUserRequest;
import com.example.ad.vo.CreateUserResponse;

public class UserServiceImpl implements IUserService {
    private final AdUserRepository userRepository;

    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) throws CommonException {
        if (!request.validate()) {
            throw new CommonException("请求参数错误");
        }
        AdUser oldUser = userRepository.
                findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new CommonException("存在同名的用户");
        }
        AdUser newUser = userRepository.save(new AdUser(
                request.getUsername(),
                CommonUtils.md5(request.getUsername())
        ));
        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
