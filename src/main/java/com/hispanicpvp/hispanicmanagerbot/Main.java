package com.hispanicpvp.hispanicmanagerbot;

import com.hispanicpvp.hispanicmanagerbot.commands.BanCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.KickCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.PingPongCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.RegisterCommand;
import com.hispanicpvp.hispanicmanagerbot.utils.Utils;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        Utils utils = new Utils();
        CommandClientBuilder client = new CommandClientBuilder();
        client.setActivity(Activity.playing("Managing discord"));
        client.setPrefix(utils.getPrefix());
        client.setOwnerId(utils.getOwnerId());
        client.setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26");
        client.addCommands(
                new PingPongCommand(),
                new KickCommand(),
                new RegisterCommand(),
                new BanCommand()
                );

        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.addEventListeners(client.build());
        builder.build();
    }
}
