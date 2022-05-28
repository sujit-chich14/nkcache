package com.example.nkcache.storage;

import java.util.Date;
import java.util.Map;

public interface ICacheRepository {
     void addValue(String key, String value, int ttl);
     String getValue(String key);
     String removeKey(String key);
     Map<String,String> getCacheMap();
     Map<String, Date> getTtlMap();
}
