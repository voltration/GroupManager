import managers.ConfigurationManager
import managers.DatabaseManager
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Main: JavaPlugin() {

    private val fileDirectory = File("plugins/GroupManager")
    private val configurationManager = ConfigurationManager(this)
    private val databaseManager = DatabaseManager(this)

    override fun onLoad() {
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs()
        }
    }

    override fun onEnable() {
        configurationManager.initialize()
        databaseManager.initialize()
    }

    override fun onDisable() {

    }
}