package com.ctw.workstation.config;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceConfigurableLifecycleManager;

import java.util.Map;

public class CommodoreTestConfig implements QuarkusTestResourceConfigurableLifecycleManager {
    @Override
    public Map<String, String> start() {
        Log.info("Starting Commodore Test Config");
        return Map.of();
    }

    @Override
    public void stop() {
        Log.info("Stopping Commodore Test Config");
    }

    @Override
    public void init(Map<String, String> initArgs) {
        Log.info("Init Commodore Test Config");
    }
}
