```java
package com.example.designpatterns.utils;

import java.util.logging.Logger;

public class RetryUtil {
    private static final Logger logger = LoggerUtil.getLogger(RetryUtil.class.getName());

    public static <T> T retryOperation(SupplierWithException<T> operation, int maxAttempts, long delayMillis) throws CustomException {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                return operation.get();
            } catch (Exception e) {
                attempts++;
                if (attempts == maxAttempts) {
                    throw new CustomException("Operation failed after " + maxAttempts + " attempts: " + e.getMessage());
                }
                logger.warning("Attempt " + attempts + " failed: " + e.getMessage());
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new CustomException("Retry interrupted: " + ie.getMessage());
                }
            }
        }
        throw new CustomException("Unexpected error in retry logic.");
    }

    @FunctionalInterface
    public interface SupplierWithException<T> {
        T get() throws Exception;
    }
}
```