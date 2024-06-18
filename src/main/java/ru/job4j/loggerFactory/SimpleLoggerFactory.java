package ru.job4j.loggerFactory;

import ru.job4j.appender.ConsoleAppender;
import ru.job4j.appender.FileAppender;
import ru.job4j.logger.LogLevel;
import ru.job4j.appender.Appender;
import ru.job4j.logger.Logger;
import ru.job4j.logger.SimpleLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SimpleLoggerFactory implements LoggerFactory {

    LogLevel logLevel;

    @Override
    public Logger getLogger() {
        Appender appender;
        if (logLevel.ordinal() <= 2) {
            appender = new ConsoleAppender();
        } else {
            appender = new FileAppender(logLevel.name() + "LOG.txt");
        }
        return new SimpleLogger(appender, logLevel);
    }
}
