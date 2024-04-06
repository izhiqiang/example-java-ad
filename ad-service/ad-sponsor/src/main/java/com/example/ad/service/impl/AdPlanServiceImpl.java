package com.example.ad.service.impl;


import com.example.ad.constant.Status;
import com.example.ad.dao.AdPlanRepository;
import com.example.ad.dao.AdUserRepository;
import com.example.ad.entity.AdPlan;
import com.example.ad.entity.AdUser;
import com.example.ad.exception.BusinessException;
import com.example.ad.service.IAdPlanService;
import com.example.ad.utils.CommonUtils;
import com.example.ad.vo.AdPlanGetRequest;
import com.example.ad.vo.AdPlanRequest;
import com.example.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdPlanServiceImpl implements IAdPlanService {

    private final AdUserRepository userRepository;
    private final AdPlanRepository planRepository;

    @Autowired
    public AdPlanServiceImpl(AdUserRepository userRepository,
                             AdPlanRepository planRepository) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }
    
    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws BusinessException {
        if (!request.createValidate()) {
            throw new BusinessException("请求参数错误");
        }
        Optional<AdUser> adUser = userRepository.findById(request.getUserId());
        if (!adUser.isPresent()) {
            throw new BusinessException("找不到数据记录");
        }
        AdPlan oldPlan = planRepository.findByUserIdAndPlanName(
                request.getUserId(), request.getPlanName()
        );
        if (oldPlan != null) {
            throw new BusinessException("存在同名的推广计划");
        }
        AdPlan newAdPlan = planRepository.save(
                new AdPlan(request.getUserId(), request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate())
                )
        );
        return new AdPlanResponse(newAdPlan.getId(),
                newAdPlan.getPlanName());
    }

    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws BusinessException {

        if (!request.validate()) {
            throw new BusinessException("请求参数错误");
        }

        return planRepository.findAllByIdInAndUserId(
                request.getIds(), request.getUserId()
        );
    }

    @Override
    @Transactional(rollbackFor = {BusinessException.class})
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws BusinessException {
        if (!request.updateValidate()) {
            throw new BusinessException("请求参数错误");
        }

        AdPlan plan = planRepository.findByIdAndUserId(
                request.getId(), request.getUserId()
        );
        if (plan == null) {
            throw new BusinessException("找不到数据记录");
        }

        if (request.getPlanName() != null) {
            plan.setPlanName(request.getPlanName());
        }
        if (request.getStartDate() != null) {
            plan.setStartDate(
                    CommonUtils.parseStringDate(request.getStartDate())
            );
        }
        if (request.getEndDate() != null) {
            plan.setEndDate(
                    CommonUtils.parseStringDate(request.getEndDate())
            );
        }

        plan.setUpdateTime(new Date());
        plan = planRepository.save(plan);

        return new AdPlanResponse(plan.getId(), plan.getPlanName());
    }

    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws BusinessException {
        if (!request.deleteValidate()) {
            throw new BusinessException("请求参数错误");
        }

        AdPlan plan = planRepository.findByIdAndUserId(
                request.getId(), request.getUserId()
        );
        if (plan == null) {
            throw new BusinessException("找不到数据记录");
        }

        plan.setPlanStatus(Status.INVALID.getStatus());
        plan.setUpdateTime(new Date());
        planRepository.save(plan);
    }
}
