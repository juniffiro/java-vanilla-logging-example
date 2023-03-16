package ua.juniffiro.logger.vanilla;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 27/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class StaticVanillaLogger {

    public static final String LOGS_FILE_PATH = "./log.txt";
    public static final Logger LOGGER = Logger.getLogger("VanillaLogger");
    private static final String PATTERN = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

    static {
        configureLogger();
    }

    public static void print(Level level, Object object) {
        LOGGER.log(level, object.toString());
    }

    private static void configureLogger() {
        Handler handler;
        try {
            handler = new FileHandler(LOGS_FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(PATTERN,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        LOGGER.addHandler(handler);
    }
}
