package com.github.ad.service.impl;

import com.github.ad.dao.AdUserRepository;
import com.github.ad.entity.AdUser;
import com.github.ad.exception.BusinessException;
import com.github.ad.service.IUserService;
import com.github.ad.utils.CommonUtils;
import com.github.ad.vo.CreateUserRequest;
import com.github.ad.vo.CreateUserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private final AdUserRepository userRepository;

    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) throws BusinessException {
        if (!request.validate()) {
            throw new BusinessException("请求参数错误");
        }
        AdUser oldUser = userRepository.
                findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new BusinessException("存在同名的用户");
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
