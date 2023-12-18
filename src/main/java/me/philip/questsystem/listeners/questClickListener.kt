package me.philip.questsystem.listeners

import me.philip.questsystem.ImportQuests
import me.philip.questsystem.QuestSystem
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class questClickListener : Listener {

    @EventHandler
    fun questClickEvent(event: InventoryClickEvent) {
        val player = event.whoClicked
        val playerUUID = player.uniqueId
        val eventInventory = event.inventory
        val playerInv = player.inventory
        val playerData = player.persistentDataContainer

        if(eventInventory != QuestSystem.guiMap[playerUUID]) return
        if(event.currentItem == null) return


        when(event.currentItem!!.itemMeta.customModelData) {
            99 -> {
                eventInventory.close()
            }
            5001 -> {
                val quests : HashMap<Any, Any> = QuestSystem.questData["quests"] as HashMap<Any, Any>
                player.sendMessage(quests.size.toString())
            }
            5002 -> {

            }
            else -> {}
        }
        event.isCancelled = true
    }
}