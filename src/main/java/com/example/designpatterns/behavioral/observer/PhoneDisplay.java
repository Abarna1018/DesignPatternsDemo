```java
package com.example.designpatterns.behavioral.observer;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class PhoneDisplay implements Observer {
    private static final Logger logger = LoggerUtil.getLogger(PhoneDisplay.class.getName());

    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Phone Display: Temperature = " + temperature + "C, Humidity = " + humidity + "%");
        logger.info("PhoneDisplay updated with temperature: " + temperature + ", humidity: " + humidity);
    }
}
```