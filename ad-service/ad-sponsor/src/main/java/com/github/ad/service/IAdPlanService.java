package com.github.ad.service;

import com.github.ad.entity.AdPlan;
import com.github.ad.exception.BusinessException;
import com.github.ad.vo.AdPlanGetRequest;
import com.github.ad.vo.AdPlanRequest;
import com.github.ad.vo.AdPlanResponse;

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
