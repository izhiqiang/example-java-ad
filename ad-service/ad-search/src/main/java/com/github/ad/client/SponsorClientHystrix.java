package com.github.ad.client;

import com.github.ad.client.vo.AdPlan;
import com.github.ad.client.vo.AdPlanGetRequest;
import com.github.ad.response.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public BaseResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new BaseResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
