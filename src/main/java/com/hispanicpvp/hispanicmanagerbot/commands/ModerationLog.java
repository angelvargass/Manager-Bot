package com.hispanicpvp.hispanicmanagerbot.commands;

import com.hispanicpvp.hispanicmanagerbot.properties.PropertiesManager;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.TextChannel;

public class ModerationLog {
    private final CommandEvent commandEvent;
    private final PropertiesManager propertiesManager;

    public ModerationLog(CommandEvent commandEvent) {
        assert commandEvent != null;
        this.commandEvent = commandEvent;
        this.propertiesManager = new PropertiesManager();
    }

    public void sendModerationLog(String message) {
        TextChannel textChannel = commandEvent.getGuild()
                .getTextChannelsByName(propertiesManager.getModerationCommandsLogChannel(),
                        true).get(0);
        textChannel.sendMessage(message).queue();


    }
}
