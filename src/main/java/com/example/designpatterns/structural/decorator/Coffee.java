```java
package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class Coffee implements Beverage {
    private static final Logger logger = LoggerUtil.getLogger(Coffee.class.getName());

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        logger.info("Calculating cost for Basic Coffee: $5.0");
        return 5.0;
    }
}
```