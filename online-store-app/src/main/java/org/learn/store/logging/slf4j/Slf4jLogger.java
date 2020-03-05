package org.learn.store.logging.slf4j;


import org.learn.store.logging.Logger;

public class Slf4jLogger implements Logger {
    private org.slf4j.Logger logger;

    public Slf4jLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void trace(String s, Object... objects) {
        logger.trace(s, objects);
    }

    @Override
    public void debug(String s, Object... objects) {
        logger.debug(s, objects);
    }

    @Override
    public void info(String s, Object... objects) {
        logger.info(s, objects);
    }

    @Override
    public void warn(String s, Object... objects) {
        logger.warn(s, objects);
    }

    @Override
    public void error(String s, Object... objects) {
        logger.error(s, objects);
    }
}
