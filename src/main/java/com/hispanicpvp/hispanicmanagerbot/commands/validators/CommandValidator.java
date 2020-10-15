package com.hispanicpvp.hispanicmanagerbot.commands.validators;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;

public class CommandValidator {
    private CommandEvent commandEvent;

    public CommandValidator(CommandEvent commandEvent) {
        assert commandEvent != null;
        this.commandEvent = commandEvent;
    }

    public boolean isAuthor() {
        Member author = commandEvent.getMember();
        Member mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);
        return mentionedMember.getId().equals(author.getId());
    }

    public boolean validateNumberOfArgs(String[] args, int expectedArgs) {
        return args.length >= (expectedArgs - 1);
    }

    public boolean isBot() {
        return commandEvent.getMember().getUser().isBot();
    }

}
