import space.kscience.dataforge.tables.Table
import java.net.URL
import java.nio.file.Path

public class ProtobufHandler {
    public companion object {
        public fun readTable(source: CharSequence) : Table<Any> { TODO() }
        public fun readTable(source: Path) : Table<Any> { TODO() }
        public fun readTable(source: URL) : Table<Any> { TODO() }

        public fun renderTable(table: Table<Any>) : String { TODO() }

        public fun saveTable(table: Table<Any>, path: Path) { TODO() }
    }
}