package com.hispanicpvp.hispanicmanagerbot.commands.moderation;

import com.hispanicpvp.hispanicmanagerbot.commands.BaseCommand;
import com.hispanicpvp.hispanicmanagerbot.commands.validators.CommandValidator;
import com.hispanicpvp.hispanicmanagerbot.commands.ModerationLog;
import com.hispanicpvp.hispanicmanagerbot.controllers.KickController;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

public class KickCommand extends BaseCommand {
    private final KickController kickController;

    public KickCommand() {
        super(KickCommand.class);
        this.name = "kick";
        this.help = "Kick users from the server.";
        this.arguments = "<user>";
        this.userPermissions = new Permission[]{
                Permission.KICK_MEMBERS
        };
        this.requiredRole = super.propertiesManager.getBasicRole();
        this.hidden = true;
        this.kickController = new KickController();
    }

    @Override
    public void execute(CommandEvent commandEvent) {
        ModerationLog moderationLog = new ModerationLog(commandEvent);
        this.commandValidator = new CommandValidator(commandEvent);
        try {
            Member author = commandEvent.getMember();
            Member mentionedMember = commandEvent.getMessage().getMentionedMembers().get(0);
            if(commandValidator.isAuthor()) {
                commandEvent.reply("You can't kick yourself!, " + author.getAsMention());
                return;
            }
            commandEvent.getGuild().kick(mentionedMember).queue();
            moderationLog.sendModerationLog("The user " + mentionedMember.getEffectiveName() +
                    " was kicked from the server.");
            kickController.register(author, mentionedMember);
        } catch (Exception e) {
            commandEvent.reply("Usage: <@user> <reason> (optional)");
        }
    }

}
