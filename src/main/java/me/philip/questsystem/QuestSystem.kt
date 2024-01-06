package me.philip.questsystem

import me.philip.questsystem.commands.importCommand
import me.philip.questsystem.commands.moneyTestCommand
import me.philip.questsystem.commands.questMenuCommand
import me.philip.questsystem.listeners.guiCloseListener
import me.philip.questsystem.listeners.questClickListener
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.HashMap

class QuestSystem : JavaPlugin() {

    companion object {
        lateinit var plugin : Plugin
        val guiMap: MutableMap<UUID, Inventory> = mutableMapOf()
        lateinit var questData : HashMap<String, Any>
    }

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Plugin starting")

        plugin = this

        registerCommands()
        registerListeners()

        //config.options().copyDefaults()
        //saveDefaultConfig()

        logger.info(ImportQuests().importQuests())

    }

    private fun registerCommands() {
        getCommand("quests")?.setExecutor(questMenuCommand())
        getCommand("testMoney")?.setExecutor(moneyTestCommand())
        getCommand("import")?.setExecutor(importCommand())
        logger.info("Registered commands")
    }

    private fun registerListeners() {
        server.pluginManager.registerEvents(questClickListener(), this)
        server.pluginManager.registerEvents(guiCloseListener(), this)
        logger.info("Registered listeners")
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Plugin stopping")
    }
}
