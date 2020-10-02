package com.hispanicpvp.hispanicmanagerbot.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.Optional;

public class CommandUtils {

    public static boolean validateArgsNumber(String[] args, int argsNumber) {
        boolean isValid = false;
        if (args.length == argsNumber) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isRegistered(Member member) {
        Optional<Role> role = member.getRoles().stream()
                .filter(r -> r.getName().equalsIgnoreCase("usuario"))
                .findFirst();
        return role.isPresent();
    }
}
