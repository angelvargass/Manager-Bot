package com.hispanicpvp.hispanicmanagerbot.commands;

import com.hispanicpvp.hispanicmanagerbot.utils.Utils;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class RegisterCommand extends Command {

    public RegisterCommand() {
        this.name = "register";
        this.help = "Register with the bot to get a role.";
        this.arguments = "<user>";
        this.cooldown = 10;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        Utils utils = new Utils();
        Member author = commandEvent.getMember();

        author.getRoles().stream()
                .filter(role -> role.getName().equalsIgnoreCase(utils.getRequiredRole()))
                .findFirst()
                .ifPresentOrElse(role -> commandEvent.reply("You are already registered."),
                        () -> {
                   Role role = commandEvent.getGuild().getRolesByName(utils.getRequiredRole(), true).get(0);
                   commandEvent.getGuild().addRoleToMember(author, role).queue();
                   commandEvent.reply("You have been registered.");
                        });
    }
}
