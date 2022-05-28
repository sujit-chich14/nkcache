package com.example.nkcache.policy.impl;

import com.example.nkcache.policy.IEvictionPolicy;
import com.example.nkcache.storage.CacheStorage;
import com.example.nkcache.storage.ICacheRepository;
import com.example.nkcache.util.CacheAsynUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class TTLEvictionPolicy implements IEvictionPolicy {
    @Autowired
    CacheAsynUtil cacheAsynUtil;

    @Override
    public void keyAccessed(String key) {

    }

    @Override
    public void evict() {
        cacheAsynUtil.removeCache();
    }
}
