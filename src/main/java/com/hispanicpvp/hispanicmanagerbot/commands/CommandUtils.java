package com.hispanicpvp.hispanicmanagerbot.commands;

import net.dv8tion.jda.api.entities.Member;


public class CommandUtils {

    public static Boolean isAuthor(Member author, Member mentionedMember) {
        return mentionedMember.getId().equals(author.getId());
    }
}
