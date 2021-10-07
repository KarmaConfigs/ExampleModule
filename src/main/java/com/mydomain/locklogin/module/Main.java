package com.mydomain.locklogin.module;

import com.mydomain.locklogin.module.command.ExampleCommand;
import com.mydomain.locklogin.module.listener.ExampleListener;
import eu.locklogin.api.module.PluginModule;
import eu.locklogin.api.module.plugin.api.command.Command;
import eu.locklogin.api.module.plugin.api.event.util.EventListener;

public class Main extends PluginModule {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void enable() {
        getConsole().sendMessage("&aExample module, just enabled!");

        Command exampleCommand = new ExampleCommand();
        EventListener exampleListener = new ExampleListener();
        getPlugin().registerCommand(exampleCommand);
        getPlugin().registerListener(exampleListener);
    }

    @Override
    public void disable() {
        getConsole().sendMessage("&cExample module, has been unloaded :c");

        //These are run automatically by LockLogin, but just in case you should do it
        //before disabling the module to avoid errors
        getPlugin().unregisterCommands();
        getPlugin().unregisterListeners();
        stopTasks();
    }
}
