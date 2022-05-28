package com.example.nkcache.provider;

import com.example.nkcache.models.enums.EvictionPolicy;
import com.example.nkcache.policy.IEvictionPolicy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


public class EvictionPolicyProvider {
    final private Map<EvictionPolicy, IEvictionPolicy> policyMap;
    @Autowired
    IEvictionPolicy evictionPolicy;
    public EvictionPolicyProvider(){
        policyMap = new HashMap<>();
        policyMap.put(EvictionPolicy.TIME_BASED,evictionPolicy);
    }
    public IEvictionPolicy getEvictionPolicy(EvictionPolicy policy){
        return policyMap.get(policy);
    }
}
