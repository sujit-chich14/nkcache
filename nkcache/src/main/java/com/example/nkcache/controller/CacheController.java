package com.example.nkcache.controller;

import com.example.nkcache.models.CacheRequest;
import com.example.nkcache.models.CacheResponse;
import com.example.nkcache.service.ICacheAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("cache/")
public class CacheController {
    @Autowired
    ICacheAccessService cacheAccessService;
    @PostMapping ("add")
    public boolean addCache(@RequestBody CacheRequest request){
        return cacheAccessService.addCache(request);
    }
    @GetMapping("get")
    public CacheResponse getCache(@RequestParam String key){
        return cacheAccessService.getCache(key);
    }
    @DeleteMapping("delete")
    public boolean deleteCache(@RequestParam String key){
        return cacheAccessService.deleteCache(key);
    }
}
