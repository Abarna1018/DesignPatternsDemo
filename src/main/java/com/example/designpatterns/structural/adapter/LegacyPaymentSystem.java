```java
package com.example.designpatterns.structural.adapter;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class LegacyPaymentSystem {
    private static final Logger logger = LoggerUtil.getLogger(LegacyPaymentSystem.class.getName());

    public void makePayment(String amount) {
        System.out.println("Legacy system processing payment of $" + amount);
        logger.info("Legacy system processed payment of $" + amount);
    }
}
```