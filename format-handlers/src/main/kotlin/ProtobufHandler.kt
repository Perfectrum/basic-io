import space.kscience.dataforge.tables.Table
import java.net.URL
import java.nio.file.Path

class ProtobufHandler {
    companion object {
        fun readTable(source: CharSequence) : Table<Any> { TODO() }
        fun readTable(source: Path) : Table<Any> { TODO() }
        fun readTable(source: URL) : Table<Any> { TODO() }

        fun renderTable(table: Table<Any>) : String { TODO() }

        fun saveTable(table: Table<Any>, path: Path) { TODO() }
    }
}