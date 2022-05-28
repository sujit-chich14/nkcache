package com.example.nkcache.service.impl;

import com.example.nkcache.models.CacheRequest;
import com.example.nkcache.models.CacheResponse;
import com.example.nkcache.service.ICacheAccessService;
import com.example.nkcache.storage.CacheStorage;
import com.example.nkcache.storage.impl.ICacheRepositoryImpl;
import org.springframework.stereotype.Component;


@Component
public class CacheServiceImpl implements ICacheAccessService {

    ICacheRepositoryImpl cacheRepository;

    @Override
    public boolean addCache(CacheRequest request) {
        cacheRepository.addValue(request.getKey(),request.getValue(),request.getTtl());
        return true;
    }

    @Override
    public CacheResponse getCache(String key) {
        CacheResponse response = new CacheResponse(key,cacheRepository.getValue(key));
        return response;
    }

    @Override
    public boolean deleteCache(String key) {
        cacheRepository.removeKey(key);
        return true;
    }
}
