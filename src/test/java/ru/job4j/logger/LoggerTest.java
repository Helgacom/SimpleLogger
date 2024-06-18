package ru.job4j.logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.appender.FileAppender;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Disabled
public class LoggerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private SimpleLogger logger;

    @BeforeEach
    public void setUp() {
        logger = new SimpleLogger(LogLevel.DEBUG);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testLoggingToFile() {
        var logger1 = new SimpleLogger(LogLevel.ERROR);
        logger1.warn("This is a warn message");
        assertThat(logger1.getAppender()).isInstanceOf(FileAppender.class);
    }

    @Test
    public void testDebugLogging() {
        logger.debug("This is a debug message");
        var expected = "This is a debug message";
        assertThat(expected).isEqualTo(outputStream.toString().trim());
    }

    @Test
    public void testInfoLogging() {
        logger.info("This is a info message");
        var expected = "This is a info message";
        assertThat(expected).isEqualTo(outputStream.toString().trim());
    }

    @Test
    public void testWarnLogging() {
        logger.warn("This is a warn message");
        var expected = "This is a warn message";
        assertThat(expected).isEqualTo(outputStream.toString().trim());
    }

    @Test
    public void testErrorLogging() {
        logger.error("This is an error message");
        var expected = "This is an error message";
        assertThat(expected).isEqualTo(outputStream.toString().trim());
    }
}