import space.kscience.dataforge.tables.Table
import java.net.URL
import java.nio.file.Path

public class HtmlHandler {
    public companion object {
        public fun readTables(source: CharSequence) : List<Table<Any>> { TODO() }
        public fun readTables(source: Path) : List<Table<Any>> { TODO() }
        public fun readTables(source: URL) : List<Table<Any>> { TODO() }

        public fun renderTable(table: Table<Any>) : String { TODO() }

        public fun saveTable(table: Table<Any>, path: Path) { TODO() }
    }
}