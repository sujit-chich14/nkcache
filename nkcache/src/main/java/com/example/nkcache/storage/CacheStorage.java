package com.example.nkcache.storage;

import com.example.nkcache.models.enums.EvictionPolicy;
import com.example.nkcache.provider.EvictionPolicyProvider;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class CacheStorage {
    private ConcurrentHashMap<String,String> cacheMap;

    private ConcurrentHashMap<String, Date> ttlMap;

    int capacity;

    EvictionPolicy policy;


    public void addValue(String key,String value,int ttl){
        cacheMap.put(key,value);
        putTTl(key,ttl);
    }

    private void putTTl(String key,int ttl){
        Instant instant =  new Date().toInstant().plusSeconds(ttl);
        Date date = Date.from(instant);
        ttlMap.put(key,date);
    }
}
