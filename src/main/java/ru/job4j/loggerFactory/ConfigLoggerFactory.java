package ru.job4j.loggerFactory;

import ru.job4j.appender.Appender;
import ru.job4j.appender.ConsoleAppender;
import ru.job4j.appender.FileAppender;
import ru.job4j.logger.LogLevel;
import ru.job4j.logger.Logger;
import ru.job4j.logger.SimpleLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoggerFactory {

    LogLevel logLevel = LogLevel.INFO;

    public Logger getConfigLogger() throws IOException {
        Appender appender = new ConsoleAppender();
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("app.properties")) {
            properties.load(input);
            String appenderType = properties.getProperty("appenderType");
            if ("fileAppender".equals(appenderType)) {
                appender = new FileAppender("log.txt");
                logLevel = LogLevel.WARN;
            }
        }
        return new SimpleLogger(appender, logLevel);
    }
}
