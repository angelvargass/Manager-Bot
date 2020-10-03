package com.hispanicpvp.hispanicmanagerbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BanCommand extends Command {
    static final Logger logger = LoggerFactory.getLogger(BanCommand.class);

    public BanCommand() {
        this.name = "ban";
        this.help = "Ban a user from the server.";
        this.arguments = "<@user> <days>";
        this.userPermissions = new Permission[] {
                Permission.BAN_MEMBERS
        };
        this.requiredRole = "Usuario";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Member mentionedMember, author = commandEvent.getMember();
        int days;
        String[] args = commandEvent.getMessage().getContentRaw().split(" ");

        try {
            mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);

            if (CommandUtils.isAuthor(author, mentionedMember)) {
                commandEvent.reply("You can't ban yourself!, " +  author.getAsMention());
                return;
            }

            days = Integer.parseInt(args[2]);
            mentionedMember.ban(days).queue();
            commandEvent.reply("The user " + mentionedMember.getEffectiveName() + " was banned from the server.");
        } catch (IndexOutOfBoundsException e) {
            commandEvent.reply("You must mention a <@user> and specify <days>");
        } catch (NumberFormatException e) {
            commandEvent.reply("<days> must be a integer number!");
        } catch (Exception e) {
            logger.error("Error ocurred on BanCommand: " + e.getMessage());
        }
    }
}
