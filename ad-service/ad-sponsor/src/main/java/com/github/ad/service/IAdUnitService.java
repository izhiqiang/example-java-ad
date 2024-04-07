package com.github.ad.service;

import com.github.ad.exception.BusinessException;
import com.github.ad.vo.*;
import com.github.ad.vo.*;

public interface IAdUnitService {
    AdUnitResponse createUnit(AdUnitRequest request) throws BusinessException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws BusinessException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws BusinessException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws BusinessException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws BusinessException;
}
