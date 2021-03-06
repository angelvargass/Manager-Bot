package com.hispanicpvp.hispanicmanagerbot.commands;

import com.hispanicpvp.hispanicmanagerbot.controllers.BanController;
import com.hispanicpvp.hispanicmanagerbot.models.Ban;
import com.hispanicpvp.hispanicmanagerbot.utils.Utils;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class BanCommand extends Command {
    static final Logger logger = LoggerFactory.getLogger(BanCommand.class);
    private final Utils utils;
    private final BanController banController;

    public BanCommand() {
        this.utils = new Utils();
        this.name = "ban";
        this.help = "Ban a user from the server.";
        this.arguments = "<@user> <days>";
        this.userPermissions = new Permission[]{
                Permission.BAN_MEMBERS
        };
        this.requiredRole = utils.getBasicRole();
        this.hidden = true;
        this.banController = new BanController();
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Utils utils = new Utils();
        Member mentionedMember, author = commandEvent.getMember();
        int days;
        String[] args = commandEvent.getMessage().getContentRaw().split(" ");
        Ban ban = new Ban();

        try {
            mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);

            if (CommandUtils.isAuthor(author, mentionedMember)) {
                commandEvent.reply("You can't ban yourself!, " + author.getAsMention());
                return;
            }

            days = Integer.parseInt(args[2]);
            mentionedMember.ban(days).queue();
            CommandUtils.sendModerationLog(commandEvent,
                    "The user " + mentionedMember.getEffectiveName() + " was banned from the server.");
            ban.setBannedDays(days);
            ban.setBannedUser(mentionedMember.getEffectiveName());
            ban.setStaffName(author.getEffectiveName());
            ban.setDate(LocalDate.now());
            banController.register(ban);
        } catch (IndexOutOfBoundsException e) {
            commandEvent.reply("You must mention a <@user> and specify <days>");
        } catch (NumberFormatException e) {
            commandEvent.reply("<days> must be a integer number!");
        } catch (Exception e) {
            CommandUtils.sendModerationLog(commandEvent, "Error ocurred on BanCommand");
            logger.error("Error ocurred on BanCommand: " + e.getMessage());
        }
    }
}
