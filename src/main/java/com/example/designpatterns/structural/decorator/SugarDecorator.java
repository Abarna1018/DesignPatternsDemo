```java
package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class SugarDecorator extends BeverageDecorator {
    private static final Logger logger = LoggerUtil.getLogger(SugarDecorator.class.getName());

    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        logger.info("Adding sugar cost: $0.5");
        return beverage.getCost() + 0.5;
    }
}
```