package com.hispanicpvp.hispanicmanagerbot.commands;

import com.hispanicpvp.hispanicmanagerbot.controllers.KickController;
import com.hispanicpvp.hispanicmanagerbot.models.Kick;
import com.hispanicpvp.hispanicmanagerbot.utils.Utils;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class KickCommand extends Command {
    static final Logger logger = LoggerFactory.getLogger(KickCommand.class);
    private final Utils utils;
    private final KickController kickController;

    public KickCommand() {
        this.utils = new Utils();
        this.name = "kick";
        this.help = "Kick users from the server.";
        this.arguments = "<user>";
        this.userPermissions = new Permission[]{
                Permission.KICK_MEMBERS
        };
        this.requiredRole = utils.getBasicRole();
        this.hidden = true;
        this.kickController = new KickController();
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Member author = commandEvent.getMember();
        Member mentionedMember;
        Kick kick = new Kick();

        try {
            mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);

            if (CommandUtils.isAuthor(author, mentionedMember)) {
                commandEvent.reply("You can't kick yourself!, " + author.getAsMention());
                return;
            }

            if (mentionedMember.isOwner()) {
                commandEvent.reply("You can't kick the server owner!, " + author.getAsMention());
                return;
            }

            commandEvent.getGuild().kick(mentionedMember).queue();
            CommandUtils.sendModerationLog(commandEvent,
                    "The user " + mentionedMember.getEffectiveName() + " was kicked from the server.");

            kick.setKickedUser(mentionedMember.getEffectiveName());
            kick.setStaffName(author.getEffectiveName());
            kick.setDate(LocalDate.now());
            kickController.register(kick);
        } catch (IndexOutOfBoundsException e) {
            commandEvent.reply("You must mention a @user");
        } catch (HierarchyException e) {
            commandEvent.reply("You need to modify the bot permissions");
        } catch (Exception e) {
            CommandUtils.sendModerationLog(commandEvent, "Error ocurred on KickCommand");
            logger.error("Error ocurred on KickCommand: " + e.getMessage());
        }
    }
}
