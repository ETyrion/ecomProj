package E2ESampleProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {

    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static Logger log = LogManager.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {

        // Set up a simple configuration that logs on the console.
        log.info("Running from log file");
        log.error("It is an error");
        log.fatal("Fatal error");

    }
}
