package com.hispanicpvp.hispanicmanagerbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.exceptions.HierarchyException;

public class KickCommand extends Command {

    public KickCommand() {
        this.name = "kick";
        this.help = "Kick users from the server";
        this.arguments = "<user>";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        String args[] = commandEvent.getArgs().split(" ");
        Member member, selfMember;

        if(!CommandUtils.validateArgsNumber(args, 1)) {
            commandEvent.reply("You must type a <@user>");
            return;
        }

        try {
            member = commandEvent.getMessage().getMentionedMembers().get(0);
        } catch (IndexOutOfBoundsException e) {
            commandEvent.reply("You must mention a @user");
            return;
        }

        selfMember = commandEvent.getSelfMember();

        if(selfMember.hasPermission(Permission.KICK_MEMBERS)) {
            try {
                commandEvent.getGuild().kick(member);
                commandEvent.reply("The user " + member.getNickname() + " was kicked from the server");
            } catch (HierarchyException e) {
                commandEvent.reply("You need to modify the bot permissions");
            }
        } else {
            commandEvent.reply("You don't have permission to kick members");
        }

    }
}
