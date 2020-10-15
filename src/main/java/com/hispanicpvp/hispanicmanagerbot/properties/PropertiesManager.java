package com.hispanicpvp.hispanicmanagerbot.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static final Properties properties = new Properties();
    private static final InputStream propertiesFile =
            PropertiesManager.class.getClassLoader().getResourceAsStream(
                    "config.properties");

    public PropertiesManager() {
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
