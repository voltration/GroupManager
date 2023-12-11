package util

import Main
import managers.ConfigurationManager
import org.bukkit.ChatColor

class Format(plugin: Main) {

    private val configurationManager = ConfigurationManager(plugin)
    private val prefix = configurationManager.getString("prefix")

    fun colored(string: String): String {
        return ChatColor.translateAlternateColorCodes('&', string)
    }

    fun pColored(string: String): String {
        return colored("$prefix $string")
    }
}