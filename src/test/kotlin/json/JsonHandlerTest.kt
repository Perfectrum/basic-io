package json

import kotlinx.serialization.json.*
import org.junit.Assert.assertEquals
import org.junit.Test
import space.kscience.dataforge.values.ValueType
import space.kscience.tables.ColumnHeader
import space.kscience.tables.MapRow
import space.kscience.tables.RowTable
import java.nio.file.Paths

internal class JsonHandlerTest {

    private val simpleJsonArray = buildJsonArray {
        addJsonObject {
            put("a", "a1")
            put("b", "b1")
        }
        addJsonObject {
            put("a", "a2")
            put("b", "b2")
        }
    }

    private val simpleJsonString = """[ { "a": "a1", "b": "b1" }, { "a": "a2", "b": "b2" } ]"""

    private val simpleTable = RowTable(
        headers = listOf(
            ColumnHeader("a", ValueType.STRING),
            ColumnHeader("b", ValueType.STRING)
        ), rows = listOf (
            MapRow( mapOf("a" to "a1", "b" to "b1") ),
            MapRow( mapOf("a" to "a2", "b" to "b2") )
        )
    )

    private val simpleJsonPath = Paths.get("./src/test/resources/tables/simple_table.json")

    private fun assertEqualsTables(table1: RowTable<Any>, table2: RowTable<Any>){
        if (table1.headers == table2.headers) {
            assertEquals(table1.rows, table2.rows)
        } else {
            return assert(false)
        }
    }

    @Test
    fun readJsonArrayTest() {
        val curTable = JsonHandler.readTable(simpleJsonArray)

        assertEqualsTables(curTable, simpleTable)
    }

    @Test
    fun readStringTest() {
        val curTable = JsonHandler.readTable(simpleJsonString)
        assertEqualsTables(curTable, simpleTable)
    }

    @Test
    fun readFileTest() {
        val curTable = JsonHandler.readTable(simpleJsonPath)
        assertEqualsTables(curTable, simpleTable)
    }

//    @Test
//    fun readUrlTest() { TODO() }

    @Test
    fun renderTest() {
        val curJsonArray = JsonHandler.renderTable(simpleTable)
        assertEquals(curJsonArray, simpleJsonArray)
    }

    @Test
    fun saveTableTest() {
        val path = Paths.get("./src/test/resources/tables/simple_tableTest.json")
        JsonHandler.saveTable(simpleTable, path)
        assertEqualsTables (
            JsonHandler.readTable(path),
            JsonHandler.readTable(simpleJsonPath)
        )
    }
}
