```java
package com.example.designpatterns;

import com.example.designpatterns.behavioral.observer.WeatherStation;
import com.example.designpatterns.behavioral.strategy.PaymentProcessor;
import com.example.designpatterns.creational.factory.DocumentFactory;
import com.example.designpatterns.creational.singleton.ConfigManager;
import com.example.designpatterns.structural.adapter.LegacyPaymentAdapter;
import com.example.designpatterns.structural.decorator.Beverage;
import com.example.designpatterns.structural.decorator.Coffee;
import com.example.designpatterns.structural.decorator.MilkDecorator;
import com.example.designpatterns.structural.decorator.SugarDecorator;
import com.example.designpatterns.utils.CustomException;
import com.example.designpatterns.utils.LoggerUtil;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerUtil.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = getValidChoice();
                if (choice == 7) {
                    logger.info("Exiting application.");
                    running = false;
                    continue;
                }
                executeUseCase(choice);
            } catch (CustomException e) {
                logger.severe("Error: " + e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Design Patterns Demo ===");
        System.out.println("1. Observer Pattern (Weather Station)");
        System.out.println("2. Strategy Pattern (Payment Processing)");
        System.out.println("3. Factory Method Pattern (Document Creator)");
        System.out.println("4. Singleton Pattern (Configuration Manager)");
        System.out.println("5. Adapter Pattern (Payment System Integration)");
        System.out.println("6. Decorator Pattern (Coffee Shop)");
        System.out.println("7. Exit");
        System.out.print("Enter your choice (1-7): ");
    }

    private static int getValidChoice() throws CustomException {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 7) {
                throw new CustomException("Choice must be between 1 and 7.");
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new CustomException("Invalid input. Please enter a number.");
        }
    }

    private static void executeUseCase(int choice) throws CustomException {
        switch (choice) {
            case 1:
                runObserverPattern();
                break;
            case 2:
                runStrategyPattern();
                break;
            case 3:
                runFactoryPattern();
                break;
            case 4:
                runSingletonPattern();
                break;
            case 5:
                runAdapterPattern();
                break;
            case 6:
                runDecoratorPattern();
                break;
        }
    }

    private static void runObserverPattern() throws CustomException {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new DashboardDisplay());
        System.out.print("Enter temperature (C): ");
        float temperature = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter humidity (%): ");
        float humidity = Float.parseFloat(scanner.nextLine());
        station.setMeasurements(temperature, humidity);
    }

    private static void runStrategyPattern() throws CustomException {
        PaymentProcessor processor = new PaymentProcessor();
        System.out.println("Select payment method: 1. Credit Card, 2. PayPal");
        int method = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        processor.setPaymentStrategy(method == 1 ? new CreditCardPayment() : new PayPalPayment());
        processor.processPayment(amount);
    }

    private static void runFactoryPattern() throws CustomException {
        System.out.println("Select document type: 1. PDF, 2. Word");
        int type = Integer.parseInt(scanner.nextLine());
        DocumentFactory factory = type == 1 ? new PDFDocumentFactory() : new WordDocumentFactory();
        factory.createDocument().generate();
    }

    private static void runSingletonPattern() {
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("Configuration: " + config.getConfig("app.name"));
    }

    private static void runAdapterPattern() throws CustomException {
        ModernPaymentGateway gateway = new LegacyPaymentAdapter(new LegacyPaymentSystem());
        System.out.print("Enter amount to process: ");
        double amount = Double.parseDouble(scanner.nextLine());
        gateway.processPayment(amount);
    }

    private static void runDecoratorPattern() throws CustomException {
        Beverage coffee = new Coffee();
        System.out.println("Add-ons: 1. Milk, 2. Sugar, 3. None");
        int addOn = Integer.parseInt(scanner.nextLine());
        if (addOn == 1) {
            coffee = new MilkDecorator(coffee);
        } else if (addOn == 2) {
            coffee = new SugarDecorator(coffee);
        }
        System.out.println(coffee.getDescription() + ": $" + coffee.getCost());
    }
}
```