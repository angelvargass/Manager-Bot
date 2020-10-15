package com.hispanicpvp.hispanicmanagerbot.commands;

import com.hispanicpvp.hispanicmanagerbot.commands.validators.CommandValidator;
import com.hispanicpvp.hispanicmanagerbot.logger.Logger;
import com.hispanicpvp.hispanicmanagerbot.properties.PropertiesManager;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class BaseCommand extends Command {

    protected Logger logger;
    protected PropertiesManager propertiesManager;
    protected CommandValidator commandValidator;

    public BaseCommand(Class childClass) {
        assert childClass != null;
        this.logger = new Logger(childClass);
        this.propertiesManager = new PropertiesManager();
        this.cooldown = 5;
    }

    @Override
    public void execute(CommandEvent commandEvent) {

    }
}
