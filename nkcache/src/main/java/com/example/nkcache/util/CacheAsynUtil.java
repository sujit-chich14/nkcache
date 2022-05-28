package com.example.nkcache.util;

import com.example.nkcache.storage.ICacheRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CacheAsynUtil {
    ICacheRepository repository;

    @Async
    public void removeCache(){
        List<String> keys = repository.getTtlMap().entrySet().stream()
                .filter(record -> record.getValue().before(new Date())).map(record -> record.getKey())
                .collect(Collectors.toList());
        keys.forEach(key-> repository.getCacheMap().remove(key));
    }
}
