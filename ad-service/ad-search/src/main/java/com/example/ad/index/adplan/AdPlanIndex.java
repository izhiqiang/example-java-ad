package com.example.ad.index.adplan;

import com.example.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class AdPlanIndex implements IndexAware<Long, AdPlanObject> {
    private static Map<Long, AdPlanObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>();
    }
    @Override
    public AdPlanObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdPlanObject value) {
        log.info("before add: {}", objectMap);
        objectMap.put(key,value);
        log.info("after add: {}", objectMap);
    }

    @Override
    public void update(Long key, AdPlanObject value) {
        log.info("before update: {}", objectMap);
        AdPlanObject  old = objectMap.get(key);
        if (old == null){
            objectMap.put(key,value);
        }else {
           old.update(value);
        }
        log.info("after add: {}", objectMap);
    }

    @Override
    public void delete(Long key, AdPlanObject value) {
        log.info("before update: {}", objectMap);
        objectMap.remove(key);
        log.info("after add: {}", objectMap);
    }
}
