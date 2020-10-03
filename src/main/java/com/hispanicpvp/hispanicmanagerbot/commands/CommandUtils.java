package com.hispanicpvp.hispanicmanagerbot.commands;

import com.hispanicpvp.hispanicmanagerbot.utils.Utils;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;


public class CommandUtils {

    public static Boolean isAuthor(Member author, Member mentionedMember) {
        return mentionedMember.getId().equals(author.getId());
    }

    public static void sendModerationLog(CommandEvent commandEvent, String message) {
        Utils utils = new Utils();
        TextChannel textChannel = commandEvent.getGuild()
                .getTextChannelsByName(utils.getModerationCommandsLogChannel(), true).get(0);
        textChannel.sendMessage(message).queue();
    }
}
