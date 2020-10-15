package com.hispanicpvp.hispanicmanagerbot.logger;

import org.slf4j.LoggerFactory;

public class Logger {

    private final org.slf4j.Logger logger;

    public Logger(Class loggerClass) {
        logger = LoggerFactory.getLogger(loggerClass);
    }

    public void error(String error) {
        logger.error(error);
    }

    public void info(String info) {
        logger.info(info);
    }
}
