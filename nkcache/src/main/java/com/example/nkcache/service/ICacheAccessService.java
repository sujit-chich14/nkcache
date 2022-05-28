package com.example.nkcache.service;


import com.example.nkcache.models.CacheRequest;
import com.example.nkcache.models.CacheResponse;

public interface ICacheAccessService {
    boolean addCache(CacheRequest request);
    CacheResponse getCache(String key);
    boolean deleteCache(String key);
}
