package ru.job4j;

import ru.job4j.appender.FileAppender;
import ru.job4j.logger.LogLevel;
import ru.job4j.logger.SimpleLogger;

public class Main {
    public static void main(String[] args) {
        var logger = new SimpleLogger(LogLevel.DEBUG);
        var logger1 = new SimpleLogger(LogLevel.ERROR);
        logger1.warn("test");
        var fileAppender = new FileAppender("log.txt");
        fileAppender.append("test");
        System.out.println(logger);
        System.out.println();
        logger.info("Info");
    }
}