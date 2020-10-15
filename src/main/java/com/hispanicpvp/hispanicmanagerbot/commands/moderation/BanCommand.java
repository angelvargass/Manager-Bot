package com.hispanicpvp.hispanicmanagerbot.commands.moderation;

import com.hispanicpvp.hispanicmanagerbot.commands.BaseCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.validators.CommandValidator;
import com.hispanicpvp.hispanicmanagerbot.commands.ModerationLog;
import com.hispanicpvp.hispanicmanagerbot.controllers.BanController;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

public class BanCommand extends BaseCommand {
    private final BanController banController;

    public BanCommand() {
        super(BanCommand.class);
        this.name = "ban";
        this.help = "Ban a user from the server.";
        this.arguments = "<@user> <days>";
        this.userPermissions = new Permission[]{
                Permission.BAN_MEMBERS
        };
        this.requiredRole = super.propertiesManager.getBasicRole();
        this.hidden = true;
        this.banController = new BanController();
    }

    @Override
    public void execute(CommandEvent commandEvent) {
        Member mentionedMember, author = commandEvent.getMember();
        CommandValidator commandValidator = new CommandValidator(commandEvent);
        ModerationLog moderationLog = new ModerationLog(commandEvent);
        String[] args = commandEvent.getMessage().getContentRaw().split(" ");
        try {
            if(commandValidator.isAuthor()) {
                commandEvent.reply("You can't ban yourself!, " + author.getAsMention());
                return;
            }
            mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);
            int days = Integer.parseInt(args[2]);
            mentionedMember.ban(days).queue();
            moderationLog.sendModerationLog("The user " + mentionedMember.getEffectiveName() +
                    " was banned from the server.");
            banController.register(author, mentionedMember, days);
        } catch (Exception e) {
            commandEvent.reply("Usage: <@user> <days>");
        }
    }
}
