package com.hispanicpvp.hispanicmanagerbot;

import com.hispanicpvp.hispanicmanagerbot.commands.moderation.BanCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.moderation.KickCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.commoncommands.RegisterCommand;
import com.hispanicpvp.hispanicmanagerbot.properties.PropertiesManager;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        PropertiesManager utils = new PropertiesManager();
        CommandClientBuilder client = new CommandClientBuilder();
        client.setActivity(Activity.playing("Managing discord"));
        client.setPrefix(utils.getPrefix());
        client.setOwnerId(utils.getOwnerId());
        client.setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26");
        client.addCommands(
                new KickCommand(),
                new RegisterCommand(),
                new BanCommand()
                );

        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.addEventListeners(client.build());
        builder.build();
    }
}
