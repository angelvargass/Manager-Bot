package com.hispanicpvp.hispanicmanagerbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KickCommand extends Command {
    static final Logger logger = LoggerFactory.getLogger(KickCommand.class);

    public KickCommand() {
        this.name = "kick";
        this.help = "Kick users from the server.";
        this.arguments = "<user>";
        this.userPermissions = new Permission[]{
                Permission.KICK_MEMBERS
        };
        this.requiredRole = "Usuario";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Member author = commandEvent.getMember();
        Member mentionedMember;

        try {
            mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);

            if (CommandUtils.isAuthor(author, mentionedMember)) {
                commandEvent.reply("You can't kick yourself!, " + author.getAsMention());
                return;
            }

            commandEvent.reply("The user " + mentionedMember.getEffectiveName() + " was kicked from the server.");
            commandEvent.getGuild().kick(mentionedMember).queue();

        } catch (IndexOutOfBoundsException e) {
            commandEvent.reply("You must mention a @user");
        } catch (HierarchyException e) {
            commandEvent.reply("You need to modify the bot permissions");
        } catch (Exception e) {
            commandEvent.reply("An error ocurred");
            logger.error("Error ocurred on KickCommand: " + e.getMessage());
        }


    }
}
