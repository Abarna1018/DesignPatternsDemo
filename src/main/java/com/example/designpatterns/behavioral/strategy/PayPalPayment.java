```java
package com.example.designpatterns.behavioral.strategy;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class PayPalPayment implements PaymentStrategy {
    private static final Logger logger = LoggerUtil.getLogger(PayPalPayment.class.getName());

    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        System.out.println("Paid $" + amount + " via PayPal.");
        logger.info("Processed PayPal payment of $" + amount);
    }
}
```