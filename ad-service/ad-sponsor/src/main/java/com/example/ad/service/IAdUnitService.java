package com.example.ad.service;

import com.example.ad.exception.BusinessException;
import com.example.ad.vo.*;

public interface IAdUnitService {
    AdUnitResponse createUnit(AdUnitRequest request) throws BusinessException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws BusinessException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws BusinessException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws BusinessException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws BusinessException;
}
