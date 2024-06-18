package ru.job4j.logger;

import ru.job4j.appender.Appender;
import ru.job4j.appender.ConsoleAppender;
import ru.job4j.appender.FileAppender;

public class SimpleLogger implements Logger {

    private Appender appender = new ConsoleAppender();
    private LogLevel level;

    public SimpleLogger(Appender appender, LogLevel level) {
        this.appender = appender;
        this.level = level;
    }

    public SimpleLogger(LogLevel level) {
        this.level = level;
        if (level.ordinal() > 2) {
            this.appender = new FileAppender(level.name() + "LOG.txt");
        }
    }

    public Appender getAppender() {
        return appender;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (level.ordinal() <= logLevel.ordinal()) {
            appender.append(message);
        }
    }

    @Override
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    @Override
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    @Override
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
