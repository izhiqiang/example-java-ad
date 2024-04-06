package com.example.ad.service;

import com.example.ad.vo.CreativeRequest;
import com.example.ad.vo.CreativeResponse;

public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
