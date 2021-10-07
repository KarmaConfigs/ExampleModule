package com.mydomain.locklogin.module.listener;

import eu.locklogin.api.module.plugin.api.event.ModuleEventHandler;
import eu.locklogin.api.module.plugin.api.event.user.UserAuthenticateEvent;
import eu.locklogin.api.module.plugin.api.event.util.EventListener;
import eu.locklogin.api.module.plugin.javamodule.sender.ModulePlayer;

public class ExampleListener implements EventListener {

    @ModuleEventHandler(priority = ModuleEventHandler.Priority.AFTER, after = "LockLoginPremium")
    public void onPostJoin(UserAuthenticateEvent e) {
        if (e.getAuthResult() == UserAuthenticateEvent.Result.SUCCESS) {
            ModulePlayer player = e.getPlayer();
            player.sendMessage("&aHello world!");

            player.requestUnlogin();
        }
    }
}
