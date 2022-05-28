package com.example.nkcache.storage.impl;

import com.example.nkcache.provider.EvictionPolicyProvider;
import com.example.nkcache.storage.CacheStorage;
import com.example.nkcache.storage.ICacheRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

public class ICacheRepositoryImpl implements ICacheRepository {
    CacheStorage storage ;
    @Autowired
    EvictionPolicyProvider policyProvider;

    @Override
    public void addValue(String key, String value, int ttl) {
        if(storage.getCacheMap().size()>=storage.getCapacity()){
            policyProvider.getEvictionPolicy(storage.getPolicy()).evict();
        }
        storage.addValue(key,value,ttl);
    }

    @Override
    public String getValue(String key) {
        return storage.getCacheMap().get(key);
    }

    @Override
    public String removeKey(String key) {
        storage.getCacheMap().remove(key);
        return key;
    }

    @Override
    public Map<String, String> getCacheMap() {
        return storage.getCacheMap();
    }

    @Override
    public Map<String, Date> getTtlMap() {
        return storage.getTtlMap();
    }
}
