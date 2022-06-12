package sv

import org.junit.Test
import org.junit.Assert.*
import space.kscience.tables.RowTable
import java.nio.file.Paths
import kotlin.io.path.readText

internal class SvHandlerFileTest {

    private fun assertEqualsTables(table1: RowTable<Any>, table2: RowTable<Any>){
        if (table1.headers == table2.headers) {
            assertEquals(table1.rows, table2.rows)
        } else {
            return assert(false)
        }
    }

    @Test
    fun airtrvelTest() {
        val tableFromString = SvHandler.readCsvTable(
            "\"Month\", \"1958\", \"1959\", \"1960\"\n" +
            "\"JAN\", 340, 360, 417\n" +
            "\"FEB\", 318, 342, 391\n" +
            "\"MAR\", 362, 406, 419\n" +
            "\"APR\", 348, 396, 461\n" +
            "\"MAY\", 363, 420, 472\n" +
            "\"JUN\", 435, 472, 535\n" +
            "\"JUL\", 491, 548, 622\n" +
            "\"AUG\", 505, 559, 606\n" +
            "\"SEP\", 404, 463, 508\n" +
            "\"OCT\", 359, 407, 461\n" +
            "\"NOV\", 310, 362, 390\n" +
            "\"DEC\", 337, 405, 432"
        )

        val filePath = Paths.get("./src/test/resources/tables/airtravel.csv")
        val testFilePath = Paths.get("./src/test/resources/tables/airtravelTest.csv")

        val tableFromFile = SvHandler.Companion.readCsvTable(filePath)

        assertEqualsTables(tableFromString, tableFromFile)

        SvHandler.Companion.saveTableToCsv(tableFromFile, testFilePath)
        assertEquals(filePath.readText(), testFilePath.readText())
    }

    @Test
    fun biostatsTest() {
        val tableFromString = SvHandler.readCsvTable(
            "\"Name\", \"Sex\", \"Age\", \"Height (in)\", \"Weight (lbs)\"\n" +
                    "\"Alex\", \"M\", 41, 74, 170\n" +
                    "\"Bert\", \"M\", 42, 68, 166\n" +
                    "\"Carl\", \"M\", 32, 70, 155\n" +
                    "\"Dave\", \"M\", 39, 72, 167\n" +
                    "\"Elly\", \"F\", 30, 66, 124\n" +
                    "\"Fran\", \"F\", 33, 66, 115\n" +
                    "\"Gwen\", \"F\", 26, 64, 121\n" +
                    "\"Hank\", \"M\", 30, 71, 158\n" +
                    "\"Ivan\", \"M\", 53, 72, 175\n" +
                    "\"Jake\", \"M\", 32, 69, 143\n" +
                    "\"Kate\", \"F\", 47, 69, 139\n" +
                    "\"Luke\", \"M\", 34, 72, 163\n" +
                    "\"Myra\", \"F\", 23, 62, 98\n" +
                    "\"Neil\", \"M\", 36, 75, 160\n" +
                    "\"Omar\", \"M\", 38, 70, 145\n" +
                    "\"Page\", \"F\", 31, 67, 135\n" +
                    "\"Quin\", \"M\", 29, 71, 176\n" +
                    "\"Ruth\", \"F\", 28, 65, 131\n"
        )

        val filePath = Paths.get("./src/test/resources/tables/biostats.csv")
        val testFilePath = Paths.get("./src/test/resources/tables/biostatsTest.csv")

        val tableFromFile = SvHandler.Companion.readCsvTable(filePath)

        assertEqualsTables(tableFromString, tableFromFile)

        SvHandler.Companion.saveTableToCsv(tableFromFile, testFilePath)
        assertEquals(filePath.readText(), testFilePath.readText())
    }

    @Test
    fun crash_cataloniaTest() {
        val tableFromString = SvHandler.readCsvTable(
            "\"Day of Week\", \"Number of Crashes\"\n" +
                "\"Sunday\", 13664\n" +
                "\"Monday\", 17279\n" +
                "\"Tuesday\", 17337\n" +
                "\"Wednesday\", 17394\n" +
                "\"Thursday\", 17954\n" +
                "\"Friday\", 19147\n" +
                "\"Saturday\", 15714"
        )

        val filePath = Paths.get("./src/test/resources/tables/crash_catalonia.csv")
        val testFilePath = Paths.get("./src/test/resources/tables/crash_cataloniaTest.csv")

        val tableFromFile = SvHandler.Companion.readCsvTable(filePath)

        assertEqualsTables(tableFromString, tableFromFile)

        SvHandler.Companion.saveTableToCsv(tableFromFile, testFilePath)
        assertEquals(filePath.readText(), testFilePath.readText())
    }

    @Test
    fun hooke() {
        val tableFromString = SvHandler.readCsvTable(
            "\"Index\", \"Mass (kg)\", \"Spring 1 (m)\", \"Spring 2 (m)\"\n" +
                    " 1, 0.00, 0.050, 0.050 \n" +
                    " 2, 0.49, 0.066, 0.066\n" +
                    " 3, 0.98, 0.087, 0.080\n" +
                    " 4, 1.47, 0.116, 0.108\n" +
                    " 5, 1.96, 0.142, 0.138\n" +
                    " 6, 2.45, 0.166, 0.158\n" +
                    " 7, 2.94, 0.193, 0.174\n" +
                    " 8, 3.43, 0.204, 0.192\n" +
                    " 9, 3.92, 0.226, 0.205\n" +
                    "10, 4.41, 0.238, 0.232"
        )

        val filePath = Paths.get("./src/test/resources/tables/hooke.csv")
        val testFilePath = Paths.get("./src/test/resources/tables/hookeTest.csv")

        val tableFromFile = SvHandler.Companion.readCsvTable(filePath)

        assertEqualsTables(tableFromString, tableFromFile)

        SvHandler.Companion.saveTableToCsv(tableFromFile, testFilePath)
        assertEquals(filePath.readText(), testFilePath.readText())
    }

    @Test
    fun tally_cabTest() {
        val tableFromString = SvHandler.readCsvTable(
            "\"Distance (miles)\", \"Fare (\$)\"\n" +
                    "4.5, 18.00\n" +
                    "26.7, 73.75\n" +
                    "6.7, 23.00\n" +
                    "16.4, 56.00\n" +
                    "32.7, 83.25\n" +
                    "5.7, 17.50\n" +
                    "77.0, 190.50\n" +
                    "8.3, 19.65"
        )

        val filePath = Paths.get("./src/test/resources/tables/tally_cab.csv")
        val testFilePath = Paths.get("./src/test/resources/tables/tally_cabTest.csv")

        val tableFromFile = SvHandler.Companion.readCsvTable(filePath)

        assertEqualsTables(tableFromString, tableFromFile)

        SvHandler.Companion.saveTableToCsv(tableFromFile, testFilePath)
        assertEquals(filePath.readText(), testFilePath.readText())
    }
}