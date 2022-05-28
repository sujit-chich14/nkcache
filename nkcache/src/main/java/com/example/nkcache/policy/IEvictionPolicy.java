package com.example.nkcache.policy;

public interface IEvictionPolicy {
    public void keyAccessed(String key);
    public void evict();
}
