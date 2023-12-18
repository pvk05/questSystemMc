package me.philip.questsystem.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class moneyTestCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>?): Boolean {
        if(sender !is Player) return false
        if(!sender.isOp) return false

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + sender.name + " 10")

        return false
    }
}