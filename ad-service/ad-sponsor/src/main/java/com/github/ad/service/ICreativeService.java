package com.github.ad.service;

import com.github.ad.vo.CreativeRequest;
import com.github.ad.vo.CreativeResponse;

public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
