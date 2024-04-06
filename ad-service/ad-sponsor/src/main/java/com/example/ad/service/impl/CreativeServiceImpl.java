package com.example.ad.service.impl;

import com.example.ad.dao.CreativeRepository;
import com.example.ad.entity.Creative;
import com.example.ad.service.ICreativeService;
import com.example.ad.vo.CreativeRequest;
import com.example.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class CreativeServiceImpl implements ICreativeService {
    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );
        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
