package com.example.ad.service;

import com.example.ad.entity.AdPlan;
import com.example.ad.exception.BusinessException;
import com.example.ad.vo.AdPlanGetRequest;
import com.example.ad.vo.AdPlanRequest;
import com.example.ad.vo.AdPlanResponse;

import java.util.List;

public interface IAdPlanService {
    /**
     * 创建推广计划
     * */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws BusinessException;

    /**
     * 获取推广计划
     * */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws BusinessException;

    /**
     * 更新推广计划
     * */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws BusinessException;

    /**
     * 删除推广计划
     * */
    void deleteAdPlan(AdPlanRequest request) throws BusinessException;
}
