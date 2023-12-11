package managers

import Main

class ConfigurationManager(private val plugin: Main) {

    fun initialize() {
        plugin.saveDefaultConfig()
    }

    fun getString(path: String): String? {
        return plugin.config.getString(path)
    }

    fun getInt(path: String): Int {
        return plugin.config.getInt(path)
    }
}