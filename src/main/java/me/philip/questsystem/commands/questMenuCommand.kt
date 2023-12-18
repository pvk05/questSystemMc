package me.philip.questsystem.commands

import me.philip.questsystem.QuestSystem
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class questMenuCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) return false

        val questMenu = Bukkit.createInventory(sender, 36, Component.text("Quests").color(TextColor.color(200, 0, 0)))

        val closeBtn = ItemStack(Material.BARRIER)
        val closeBtnMeta = closeBtn.itemMeta
        closeBtnMeta.displayName(Component.text("Close").color(TextColor.color(255,0,0)))
        closeBtnMeta.setCustomModelData(99)
        closeBtn.itemMeta = closeBtnMeta
        questMenu.setItem(31, closeBtn)

        val previousBtn = ItemStack(Material.ARROW)
        val previousBtnMeta = previousBtn.itemMeta
        previousBtnMeta.displayName(Component.text("Previous"))
        previousBtnMeta.setCustomModelData(5001)
        previousBtn.itemMeta = previousBtnMeta
        questMenu.setItem(30, previousBtn)

        val nextBtn = ItemStack(Material.ARROW)
        val nextBtnMeta = nextBtn.itemMeta
        nextBtnMeta.displayName(Component.text("Next"))
        nextBtnMeta.setCustomModelData(5002)
        nextBtn.itemMeta = nextBtnMeta
        questMenu.setItem(32, nextBtn)

        val blank = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
        val blankMeta = blank.itemMeta
        blankMeta.displayName(Component.text(""))
        blank.itemMeta = blankMeta

        for(x in 0..9) {
            questMenu.setItem(x, blank)
        }
        questMenu.setItem(17, blank)
        questMenu.setItem(18, blank)
        for(x in 26..35) {
            if(x == 30) continue
            if(x == 31) continue
            if(x == 32) continue
            questMenu.setItem(x, blank)
        }

        QuestSystem.guiMap[sender.uniqueId] = questMenu
        sender.openInventory(questMenu)

        return false
    }
}