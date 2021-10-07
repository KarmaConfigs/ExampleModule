package com.mydomain.locklogin.module.listener;

import com.mydomain.locklogin.module.Main;
import eu.locklogin.api.module.plugin.api.event.ModuleEventHandler;
import eu.locklogin.api.module.plugin.api.event.user.UserAuthenticateEvent;
import eu.locklogin.api.module.plugin.api.event.user.UserJoinEvent;
import eu.locklogin.api.module.plugin.api.event.user.UserPostJoinEvent;
import eu.locklogin.api.module.plugin.api.event.user.UserPreJoinEvent;
import eu.locklogin.api.module.plugin.api.event.util.EventListener;
import eu.locklogin.api.module.plugin.javamodule.sender.ModulePlayer;

public class ExampleListener implements EventListener {

    @ModuleEventHandler(priority = ModuleEventHandler.Priority.AFTER, after = "LockLoginPremium")
    public void onAuthenticate(UserAuthenticateEvent e) {
        if (e.getAuthResult() == UserAuthenticateEvent.Result.SUCCESS) {
            ModulePlayer player = e.getPlayer();
            player.sendMessage("&aHello world!");

            player.requestUnlogin();
        }
    }

    @ModuleEventHandler(priority = ModuleEventHandler.Priority.FIRST)
    public void beforeConnection(UserPreJoinEvent e) {
        Main.getInstance().getConsole().sendMessage("&a{0}&7[{1}]&a joined from&7 {1}",
                e.getName(),
                e.getAccountId().getId(),
                e.getIp().getHostAddress());
    }

    @ModuleEventHandler(priority = ModuleEventHandler.Priority.LAST)
    public void inConnection(UserJoinEvent e) {
        Main.getInstance().getConsole().sendMessage("&a{0} passed the server-connection!", e.getName());
    }

    //This is the default configuration, if you want your events to be processed as normal, you can do it that way or
    //leaving just @ModuleEventHandler
    @ModuleEventHandler(priority = ModuleEventHandler.Priority.NORMAL)
    public void isConnected(UserPostJoinEvent e) {
        ModulePlayer player = e.getPlayer();

        Main.getInstance().getConsole().sendMessage("&a{0} is now completely in the server", player.getName());
        player.getSession().setCaptchaLogged(true);

        player.sendActionBar("&aWelcome {0} to &7MyServer!!");
    }
}
