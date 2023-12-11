package managers

import Main
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class DatabaseManager(plugin: Main) {

    private val configurationManager = ConfigurationManager(plugin)

    object Users : UUIDTable() {
        val group: Column<String> = varchar("group", 255)
    }

    data class User(val id: UUID, val group: String)

    fun initialize() {
        val port = configurationManager.getInt("port")
        val host = configurationManager.getString("host")
        val user = configurationManager.getString("user")
        val pass = configurationManager.getString("pass")

        Database.connect(
            url = "jdbc:mysql://$host:$port/ssmp",
            driver = "com.mysql.cj.jdbc.Driver",
            user = user.toString(),
            password = pass.toString()
        )

        transaction {
            SchemaUtils.create(Users)
        }
    }
}