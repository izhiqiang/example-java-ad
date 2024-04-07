package com.github.ad.controller;

import com.alibaba.fastjson.JSON;
import com.github.ad.annotation.IgnoreResponseAdvice;
import com.github.ad.client.SponsorClient;
import com.github.ad.client.vo.AdPlan;
import com.github.ad.client.vo.AdPlanGetRequest;
import com.github.ad.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class SearchController {
    private final RestTemplate restTemplate;

    @Autowired
    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate,SponsorClient sponsorClient) {

        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @SuppressWarnings("all")
    // 在/ad-sponsor/get/adPlan 返回CommonResponse<List<AdPlan>> 所有将不需要再次包装一层，过滤掉
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlans")
    public BaseResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request
    ) {
        log.info("ad-search: getAdPlansByRibbon -> {}",
                JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }
    @SuppressWarnings("all")
    // 在/ad-sponsor/get/adPlan 返回CommonResponse<List<AdPlan>> 所有将不需要再次包装一层，过滤掉
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlansByRibbon")
    public BaseResponse<List<AdPlan>> getAdPlansByRebbon(
            @RequestBody AdPlanGetRequest request
    ) {
        log.info("ad-search: getAdPlansByRibbon -> {}",
                JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                BaseResponse.class
        ).getBody();
    }
}
