package com.mydomain.locklogin.module.command;

import eu.locklogin.api.module.plugin.api.command.Command;
import eu.locklogin.api.module.plugin.javamodule.sender.ModuleSender;
import ml.karmaconfigs.api.common.utils.StringUtils;

import java.util.Arrays;

public class ExampleCommand extends Command {

    private final static boolean hideFromConsole = false;

    public ExampleCommand() {
        super("This is the command description", hideFromConsole, "example", "sample");
    }

    @Override
    public void processCommand(String label, ModuleSender sender, String... args) {
        sender.sendMessage("&7{0}&b ( you ) ran the command&7 {1}&b with the arguments&7 {2}",
                sender.getName(),
                label,
                StringUtils.listToString(Arrays.asList(args), true).replace(" ", "&f, &7"));
    }
}
