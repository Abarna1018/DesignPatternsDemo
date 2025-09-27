```java
package com.example.designpatterns.structural.decorator;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class MilkDecorator extends BeverageDecorator {
    private static final Logger logger = LoggerUtil.getLogger(MilkDecorator.class.getName());

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        logger.info("Adding milk cost: $1.0");
        return beverage.getCost() + 1.0;
    }
}
```