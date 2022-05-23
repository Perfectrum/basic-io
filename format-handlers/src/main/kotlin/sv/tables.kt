package sv

import space.kscience.dataforge.tables.Table
import java.net.URL
import java.nio.file.Path

fun SvHandler.Companion.readTable(
    source: CharSequence,
    valueSeparator: String,
    lineSeparator: String = "\n"
) : Table<Any> { TODO() }

fun SvHandler.Companion.readTable(
    source: Path,
    valueSeparator: String,
    lineSeparator: String = "\n",
    skipLines: Int = 0
) : Table<Any> { TODO() }

fun SvHandler.Companion.readTable(
    source: URL,
    valueSeparator: String,
    lineSeparator: String = "\n",
    skipLines: Int = 0
) : Table<Any> { TODO() }

fun SvHandler.Companion.readCsvTable(source: CharSequence) = readTable(source, valueSeparator = ",")
fun SvHandler.Companion.readCsvTable(source: Path) = readTable(source, valueSeparator = ",")
fun SvHandler.Companion.readCsvTable(source: URL) = readTable(source, valueSeparator = ",")

fun SvHandler.Companion.readTsvTable(source: CharSequence) = readTable(source, valueSeparator = "\t")
fun SvHandler.Companion.readTsvTable(source: Path) = readTable(source, valueSeparator = "\t")
fun SvHandler.Companion.readTsvTable(source: URL) = readTable(source, valueSeparator = "\t")

fun SvHandler.Companion.readPsvTable(source: CharSequence) = readTable(source, valueSeparator = "|")
fun SvHandler.Companion.readPsvTable(source: Path) = readTable(source, valueSeparator = "|")
fun SvHandler.Companion.readPsvTable(source: URL) = readTable(source, valueSeparator = "|")

fun SvHandler.Companion.saveTable(
    table: Table<Any>,
    path: Path,
    valueSeparator: String,
    lineSeparator: String = "\n"
) : Table<Any> { TODO() }

fun SvHandler.Companion.saveTableToCsv(table: Table<Any>, path: Path) = saveTable(table, path, valueSeparator = ",")
fun SvHandler.Companion.saveTableToTsv(table: Table<Any>, path: Path) = saveTable(table, path, valueSeparator = "\t")
fun SvHandler.Companion.saveTableToPsv(table: Table<Any>, path: Path) = saveTable(table, path, valueSeparator = "|")
