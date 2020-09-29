package com.hispanicpvp.hispanicmanagerbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PingPongCommand extends Command {

    public PingPongCommand() {
        this.name = "ping";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.reply("pong");
    }
}
