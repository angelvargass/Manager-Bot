package com.hispanicpvp.hispanicmanagerbot.commands;

public class CommandUtils {

    public static boolean validateArgsNumber(String[] args, int argsNumber) {
        boolean isValid = false;
        if(args.length == argsNumber) {
            isValid = true;
        }

        return isValid;
    }
}
