package ru.job4j.appender;

public class ConsoleAppender implements Appender {

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
