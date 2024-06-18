package ru.job4j.logger;

public interface Logger {

    void log(LogLevel level, String message);

    void error(String message);

    void warn(String message);

    void debug(String message);

    void info(String message);
}
