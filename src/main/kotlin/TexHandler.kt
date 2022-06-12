import space.kscience.dataforge.tables.Table
import space.kscience.kmath.nd.Structure2D
import java.nio.file.Path

public class TexHandler {
    public companion object {
        public fun renderTable(table: Table<Any>) : String { TODO() }

        public fun saveTable(table: Table<Any>, path: Path) { TODO() }

        public fun render2dStructure(data: Structure2D<Any>) : String { TODO() }

        public fun save2dStructure(data: Structure2D<Any>, path: Path) { TODO() }
    }
}