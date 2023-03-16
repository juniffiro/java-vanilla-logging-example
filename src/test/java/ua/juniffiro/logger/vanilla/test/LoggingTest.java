package ua.juniffiro.logger.vanilla.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.juniffiro.logger.vanilla.StaticVanillaLogger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ua.juniffiro.logger.vanilla.StaticVanillaLogger.LOGGER;
import static ua.juniffiro.logger.vanilla.StaticVanillaLogger.print;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 02/03/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class LoggingTest {

    @BeforeAll
    public static void startTesting() {
        System.out.println("Starts logging test");
    }

    @BeforeEach
    public void startTest() {
        assertNotNull(LOGGER);
        assertTrue(Files.exists(
                Paths.get(StaticVanillaLogger.LOGS_FILE_PATH)));
    }

    @Test
    public void testLoggingInfo() {
        LOGGER.info("Test info...");
    }

    @Test
    public void testLoggingWarn() {
        LOGGER.warning("Warning test.");
    }

    @Test
    public void testLoggingSevere() {
        LOGGER.severe("Error test.");
    }

    @Test
    public void testLevelLogger() {
        LOGGER.log(Level.INFO, "Hello info level.");
    }

    @Test
    public void testPrint() {
        print(Level.INFO,
                Arrays.asList("Student-Egor", "Student-Dasha", "Student-Tony"));
    }
}
