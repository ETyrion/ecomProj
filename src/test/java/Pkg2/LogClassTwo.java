package Pkg2;

import E2ESampleProject.LoggingExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogClassTwo {

    private static Logger log = LogManager.getLogger(LogClassTwo.class.getName());

    public static void main(String[] args) {

        // Set up a simple configuration that logs on the console.

        log.info("Running from log file");
        log.error("it is an error");
        log.fatal("Fatal error");

    }
}
