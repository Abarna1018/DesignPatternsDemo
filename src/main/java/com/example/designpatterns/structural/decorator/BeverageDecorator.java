```java
package com.example.designpatterns.structural.decorator;

public abstract class BeverageDecorator implements Beverage {
    protected final Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        if (beverage == null) {
            throw new IllegalArgumentException("Beverage cannot be null.");
        }
        this.beverage = beverage;
    }
}
```