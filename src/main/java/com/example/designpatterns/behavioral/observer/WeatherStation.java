```java
package com.example.designpatterns.behavioral.observer;

import com.example.designpatterns.utils.CustomException;
import com.example.designpatterns.utils.LoggerUtil;
import com.example.designpatterns.utils.RetryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WeatherStation {
    private static final Logger logger = LoggerUtil.getLogger(WeatherStation.class.getName());
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
        logger.info("Added observer: " + observer.getClass().getSimpleName());
    }

    public void setMeasurements(float temperature, float humidity) throws CustomException {
        if (temperature < -50 || temperature > 50 || humidity < 0 || humidity > 100) {
            throw new CustomException("Invalid temperature or humidity values.");
        }
        RetryUtil.retryOperation(() -> {
            this.temperature = temperature;
            this.humidity = humidity;
            notifyObservers();
            return null;
        }, 3, 1000);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
        logger.info("Notified all observers with temperature: " + temperature + ", humidity: " + humidity);
    }
}
```