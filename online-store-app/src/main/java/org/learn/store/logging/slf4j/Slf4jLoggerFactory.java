package org.learn.store.logging.slf4j;


import org.learn.store.logging.Logger;
import org.learn.store.logging.LoggerFactory;

public class Slf4jLoggerFactory implements LoggerFactory {
    private static final Slf4jLoggerFactory instance = new Slf4jLoggerFactory();

    private Slf4jLoggerFactory() {
    }

    public static Slf4jLoggerFactory getInstance() {
        return instance;
    }

    @Override
    public Logger getLogger(Class<?> clazz) {
        return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(clazz));
    }

    @Override
    public Logger getLogger(String name) {
        return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(name));
    }

}
