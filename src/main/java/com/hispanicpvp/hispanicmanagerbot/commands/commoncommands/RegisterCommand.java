package com.hispanicpvp.hispanicmanagerbot.commands.commoncommands;

import com.hispanicpvp.hispanicmanagerbot.commands.BaseCommand;
import com.hispanicpvp.hispanicmanagerbot.properties.PropertiesManager;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class RegisterCommand extends BaseCommand {

    public RegisterCommand() {
        super(RegisterCommand.class);
        this.name = "register";
        this.help = "Register with the bot to get a role.";
        this.arguments = "<user>";
    }

    @Override
    public void execute(CommandEvent commandEvent) {
        PropertiesManager utils = new PropertiesManager();
        Member author = commandEvent.getMember();

        author.getRoles().stream()
                .filter(role -> role.getName().equalsIgnoreCase(utils.getBasicRole()))
                .findFirst()
                .ifPresentOrElse(role -> commandEvent.reply("You are already registered."),
                        () -> {
                   Role role = commandEvent.getGuild().getRolesByName(utils.getBasicRole(), true).get(0);
                   commandEvent.getGuild().addRoleToMember(author, role).queue();
                   commandEvent.reply("You have been registered.");
                        });
    }
}
