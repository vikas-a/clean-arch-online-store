package org.learn.store.logging;

public interface LoggerFactory {
    Logger getLogger(Class<?> clazz);

    Logger getLogger(String name);
}
