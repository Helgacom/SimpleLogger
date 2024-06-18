package ru.job4j.logger;

public enum LogLevel {
    INFO("Info"),
    DEBUG("Debug"),
    WARN("Warn"),
    ERROR("Error");

    private String info;

    LogLevel(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
