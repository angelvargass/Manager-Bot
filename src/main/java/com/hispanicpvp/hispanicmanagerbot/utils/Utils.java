package com.hispanicpvp.hispanicmanagerbot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    private static final Properties properties = new Properties();
    private static final InputStream propertiesFile =
            Utils.class.getClassLoader().getResourceAsStream(
                    "config.properties");

    public Utils() {
        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPrefix() {
        return properties.getProperty("PREFIX");
    }

    public String getOwnerId() { return properties.getProperty("OWNER_ID"); }

    public String getBasicRole() { return properties.getProperty("basicRole"); }

    public String getModerationCommandsLogChannel() { return properties.getProperty("moderationCommandsLogsChannel"); }
}
