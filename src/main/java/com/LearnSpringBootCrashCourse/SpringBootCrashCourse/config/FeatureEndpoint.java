package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.config;

import com.fasterxml.jackson.core.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Creating custom endpoints for Spring Actuator

@Component
@Endpoint(id="features")// Making FeatureEndpoint as endpoint for the Actuator
public class FeatureEndpoint {
    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    // Creating the endpoints
    // Endpoint to get the features
    @ReadOperation // It will be GET operation
    public Map<String, Feature> features() {
        return featureMap;
    }

    // Endpoint to gather details of selected feature
    @ReadOperation
    public Feature feature(@Selector String featureName) {
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
