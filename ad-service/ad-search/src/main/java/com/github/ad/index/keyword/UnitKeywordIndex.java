package com.github.ad.index.keyword;

import com.github.ad.index.IndexAware;
import com.github.ad.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@Component
public class UnitKeywordIndex implements IndexAware<String, Set<Long>> {
    private static Map<String, Set<Long>> keywordUnitMap;
    private static Map<Long, Set<String>> unitKeywordMap;

    static {
        keywordUnitMap = new ConcurrentHashMap<>();
        unitKeywordMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        //如果传入的是空就返回空集合
        if (StringUtils.isEmpty(key)) {
            return Collections.emptySet();
        }
        Set<Long> result = keywordUnitMap.get(key);
        if (result == null) {
            return Collections.emptySet();
        }
        return result;
    }

    @Override
    public void add(String key, Set<Long> value) {
        log.info("UnitKeywordIndex, before add: {}", unitKeywordMap);
        Set<Long> unitIdSet = CommonUtil.getorCreate(key, keywordUnitMap, ConcurrentSkipListSet::new);
        unitIdSet.addAll(value);
        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtil.getorCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.add(key);
        }
        log.info("UnitKeywordIndex, after add: {}", unitKeywordMap);
    }

    @Override
    public void update(String key, Set<Long> value) {
        log.error("keyword index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {
        log.info("UnitKeywordIndex, before delete: {}", unitKeywordMap);

        Set<Long> unitIds = CommonUtil.getorCreate(
                key, keywordUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.removeAll(value);
        for (Long unitId : value) {
            Set<String> keywordSet = CommonUtil.getorCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.remove(key);
        }
        log.info("UnitKeywordIndex, after delete: {}", unitKeywordMap);
    }

    public boolean match(Long unitId, List<String> keywords) {
        //unitKeywordMap.containsKey(unitId) 推广单元是否包含推广单元ID
        // CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId)) 判断unitKeywor 不为空或null
        if (unitKeywordMap.containsKey(unitId) && CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId))) {
            Set<String> unitKeywords = unitKeywordMap.get(unitId);
            //判断keywords 中是否包含unitKeywords
            return CollectionUtils.isSubCollection(keywords, unitKeywords);
        }
        return false;
    }
}
