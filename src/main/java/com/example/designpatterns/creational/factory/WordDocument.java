```java
package com.example.designpatterns.creational.factory;

import com.example.designpatterns.utils.LoggerUtil;

import java.util.logging.Logger;

public class WordDocument implements Document {
    private static final Logger logger = LoggerUtil.getLogger(WordDocument.class.getName());

    @Override
    public void generate() {
        System.out.println("Generating Word document...");
        logger.info("Generated Word document.");
    }
}
```