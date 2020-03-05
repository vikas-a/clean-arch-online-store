package org.learn.store.logging;

public interface Logger {
    void trace(String s, Object... objects);

    void debug(String s, Object... objects);

    void info(String s, Object... objects);

    void warn(String s, Object... objects);

    void error(String s, Object... objects);
}
