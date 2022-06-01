package sv

import org.junit.Test
import org.junit.Assert.*
import space.kscience.dataforge.values.ValueType
import space.kscience.tables.*

internal class SvHandlerTest {

    private val referenceTable = RowTable(
        headers = listOf("a", "b", "c").map { ColumnHeader(it, ValueType.STRING) },
        rows = listOf(
            MapRow(mapOf("a" to "a1", "b" to "b1", "c" to "c1")),
            MapRow(mapOf("a" to "a2", "b" to "b2", "c" to "c2"))
        )
    )

    private fun assertEqualsTables(table1: Table<Any>, table2: Table<Any>){
        if (table1.columns.map{it.name} == table2.columns.map{it.name}) {
            assertEquals(table1.rows, table2.rows)
        }
    }

    @Test
    fun readTxtTableTest() {
        val tableFromCsv = SvHandler.readTable(
            "a b c\na1 b1 c1\na2 b2 c2",
            valueSeparator = " "
        )
        assertEqualsTables(tableFromCsv, referenceTable)
    }

    @Test
    fun readCsvTableTest() {
        val tableFromCsv = SvHandler.readCsvTable("a, b, c\na1, b1, c1\na2, b2, c2")
        assertEqualsTables(tableFromCsv, referenceTable)
    }

    @Test
    fun readPsvTableTest() {
        val tableFromCsv = SvHandler.readCsvTable("a|b|c\na1|b1|c1\na2|b2|c2")
        assertEqualsTables(tableFromCsv, referenceTable)
    }

    @Test
    fun readTsvTableTest() {
        val tableFromCsv = SvHandler.readCsvTable("a\tb\tc\na1\tb1\tc1\na2\tb2\tc2")
        assertEqualsTables(tableFromCsv, referenceTable)
    }

    @Test
    fun renderTableToTextTest() {
        val stringFromTable = SvHandler.renderTableToString(referenceTable)
        val referenceString = "a b c\na1 b1 c1\na2 b2 c2"
        assertEquals(referenceString, stringFromTable)
    }

    @Test
    fun renderTableToCsvTextTest() {
        val stringFromTable = SvHandler.renderTableToCsvString(referenceTable)
        val referenceString = "a,b,c\na1,b1,c1\na2,b2,c2"
        assertEquals(referenceString, stringFromTable)
    }

    @Test
    fun renderTableToPsvTextTest() {
        val stringFromTable = SvHandler.renderTableToPsvString(referenceTable)
        val referenceString = "a|b|c\na1|b1|c1\na2|b2|c2"
        assertEquals(referenceString, stringFromTable)
    }

    @Test
    fun renderTableToTsvTextTest() {
        val stringFromTable = SvHandler.renderTableToTsvString(referenceTable)
        val referenceString = "a\tb\tc\na1\tb1\tc1\na2\tb2\tc2"
        assertEquals(referenceString, stringFromTable)
    }
}