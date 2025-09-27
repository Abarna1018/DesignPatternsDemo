```java
package com.example.designpatterns.creational.singleton;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ConfigManager {
    private static final Logger logger = LoggerUtil.getLogger(ConfigManager.class.getName());
    private static volatile ConfigManager instance;
    private final Map<String, String> configMap;

    private ConfigManager() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
        configMap = new HashMap<>();
        configMap.put("app.name", "DesignPatternsDemo");
        logger.info("ConfigManager initialized.");
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getConfig(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Configuration key cannot be null or empty.");
        }
        return configMap.getOrDefault(key, "Not found");
    }
}
```