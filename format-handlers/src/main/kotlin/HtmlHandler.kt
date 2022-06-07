import space.kscience.dataforge.tables.Table
import java.net.URL
import java.nio.file.Path

class HtmlHandler {
    companion object {
        fun readTables(source: CharSequence) : List<Table<Any>> { TODO() }
        fun readTables(source: Path) : List<Table<Any>> { TODO() }
        fun readTables(source: URL) : List<Table<Any>> { TODO() }

        fun renderTable(table: Table<Any>) : String { TODO() }

        fun saveTable(table: Table<Any>, path: Path) { TODO() }
    }
}