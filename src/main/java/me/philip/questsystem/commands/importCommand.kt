package me.philip.questsystem.commands

import me.philip.questsystem.QuestSystem
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.kohsuke.github.GHGist
import org.kohsuke.github.GitHub

class importCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>?): Boolean {
        if(!sender.isOp) return false

        val github = GitHub.connect()
        val gist = github.getGist("942b9c9034279007b652b946549ac4b0")
        QuestSystem.plugin.logger.info(gist.toString())
        return false
    }
}
