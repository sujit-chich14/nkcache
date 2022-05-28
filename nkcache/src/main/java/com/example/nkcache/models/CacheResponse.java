package com.example.nkcache.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CacheResponse {
    String key;
    String value;
}
