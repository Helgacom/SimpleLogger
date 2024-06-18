package ru.job4j.appender;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FileAppenderTest {

    File file = new File("log.txt");

    @AfterEach
    public void clean() {
        file.delete();
    }

    @Test
    public void testFileAppender() {
        FileAppender fileAppender = new FileAppender(file.getPath());
        fileAppender.append("test");
        assertThat(fileAppender.getFilePath()).isEqualTo("log.txt");
        assertThat(file).exists()
                .canRead();
    }
}