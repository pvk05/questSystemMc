package me.philip.questsystem

import com.google.gson.Gson
import java.io.File
import java.io.FileReader


class ImportQuests {

    fun importQuests(): String {


        val supabase = createSupabaseClient(
            supabaseUrl = "https://xyzcompany.supabase.co",
            supabaseKey = "public-anon-key"
        ) {
            install(Auth)
            install(Postgrest)
            //install other modules
        }

        return "importing quests"

        /*
        val file = File(QuestSystem.plugin.dataFolder.absolutePath + "/quests.json")
        file.parentFile.mkdir()

        if(!file.exists()) {
            QuestSystem.plugin.logger.warning("Quest file missing!")
            return
        }

        QuestSystem.questData = Gson().fromJson(FileReader(file), HashMap<String, Any>().javaClass)

        QuestSystem.plugin.logger.info(QuestSystem.questData.toString())

         */
        /*
        val file = File(QuestSystem.plugin.dataFolder.absolutePath + "/quests.yml")
        file.parentFile.mkdir()

        if(!file.exists()) {
            QuestSystem.plugin.logger.warning("Quest file missing!")
            return
        }
        */
    }

}