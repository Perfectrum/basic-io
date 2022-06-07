import space.kscience.dataforge.tables.Table
import space.kscience.kmath.nd.Structure2D
import java.nio.file.Path

class TexHandler {
    companion object {
        fun renderTable(table: Table<Any>) : String { TODO() }

        fun saveTable(table: Table<Any>, path: Path) { TODO() }

        fun render2dStructure(data: Structure2D<Any>) : String { TODO() }

        fun save2dStructure(data: Structure2D<Any>, path: Path) { TODO() }
    }
}