package com.example.nkcache.models;

import lombok.Data;

@Data
public class CacheRequest {
    String key;
    String value;
    int ttl;
}
