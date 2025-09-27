```java
package com.example.designpatterns.structural.adapter;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class LegacyPaymentAdapter implements ModernPaymentGateway {
    private static final Logger logger = LoggerUtil.getLogger(LegacyPaymentAdapter.class.getName());
    private final LegacyPaymentSystem legacySystem;

    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        if (legacySystem == null) {
            throw new IllegalArgumentException("Legacy system cannot be null.");
        }
        this.legacySystem = legacySystem;
        logger.info("LegacyPaymentAdapter initialized.");
    }

    @Override
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        legacySystem.makePayment(String.valueOf(amount));
    }
}
```