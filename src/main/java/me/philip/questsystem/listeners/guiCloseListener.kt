package me.philip.questsystem.listeners

import me.philip.questsystem.QuestSystem
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class guiCloseListener : Listener {

    @EventHandler
    fun guiCloseEvent(event: InventoryCloseEvent) {
        val player = event.player
        val playerUUID = player.uniqueId

        if(QuestSystem.guiMap.containsKey(playerUUID)) QuestSystem.guiMap.remove(playerUUID, event.inventory)
    }
}