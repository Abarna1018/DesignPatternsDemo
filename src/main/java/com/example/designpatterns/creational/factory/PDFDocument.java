```java
package com.example.designpatterns.creational.factory;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class PDFDocument implements Document {
    private static final Logger logger = LoggerUtil.getLogger(PDFDocument.class.getName());

    @Override
    public void generate() {
        System.out.println("Generating PDF document...");
        logger.info("Generated PDF document.");
    }
}
```