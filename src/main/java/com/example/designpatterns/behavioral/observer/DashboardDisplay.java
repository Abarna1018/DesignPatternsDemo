```java
package com.example.designpatterns.behavioral.observer;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class DashboardDisplay implements Observer {
    private static final Logger logger = LoggerUtil.getLogger(DashboardDisplay.class.getName());

    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Dashboard Display: Temp = " + temperature + "°C, Humidity = " + humidity + "%");
        logger.info("DashboardDisplay updated with temperature: " + temperature + ", humidity: " + humidity);
    }
}
```