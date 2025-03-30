package com.java.designpatterns.structural.decorator;

import static java.lang.System.*;

interface Logger {
    void log(String message);
}

class LoggerImpl implements Logger {
    @Override
    public void log(String message) {
        out.println(message);
    }
}

class LoggerDecorator implements Logger {
    private final Logger logger;
    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(currentTimeMillis() + ": " + message);
    }
}
//Advantage: The Decorator pattern allows you to add new functionalities to an object without modifying its structure.
public class ImplementLoggerUsingDecorator {
    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        LoggerDecorator decorator = new LoggerDecorator(logger);
        Logger loggerDecorator = new LoggerDecorator(decorator);
        loggerDecorator.log("Hello World");
    }
}
