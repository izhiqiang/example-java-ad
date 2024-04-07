package com.example.ad.client;

import com.example.ad.client.vo.AdPlan;
import com.example.ad.client.vo.AdPlanGetRequest;
import com.example.ad.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//fallback 服务降级，一旦服务不可用情况下，就会走SponsorClientHystrix.getAdPlans方法
@FeignClient(value = "eureka-client-ad-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {
    @RequestMapping(value = "/ad-sponsor/get/adPlan", method = RequestMethod.POST)
    BaseResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);
}
