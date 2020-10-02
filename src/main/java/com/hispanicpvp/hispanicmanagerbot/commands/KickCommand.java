package com.hispanicpvp.hispanicmanagerbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.exceptions.HierarchyException;

public class KickCommand extends Command {

    public KickCommand() {
        this.name = "kick";
        this.help = "Kick users from the server.";
        this.arguments = "<user>";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Member author = commandEvent.getMember();

        Member mentionedMember;

        try {
            mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);

            if(!CommandUtils.isRegistered(author)) {
                commandEvent.reply("You aren't registered with the bot");
                return;
            } else if(mentionedMember.getId().equals(author.getId())) {
                commandEvent.reply("You can't kick yourself");
                return;
            }
            if (author.hasPermission(Permission.KICK_MEMBERS)) {
                commandEvent.reply("The user " + mentionedMember.getEffectiveName() + " was kicked from the server");
                commandEvent.getGuild().kick(mentionedMember).queue();
            } else {
                commandEvent.reply("You don't have permission to kick members");
            }

        } catch (IndexOutOfBoundsException e) {
            commandEvent.reply("You must mention a @user");
        } catch (HierarchyException e) {
            commandEvent.reply("You need to modify the bot permissions");
        }


    }
}
