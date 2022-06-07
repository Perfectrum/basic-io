package sv

import space.kscience.dataforge.values.ValueType
import space.kscience.tables.ColumnHeader
import space.kscience.tables.RowTable
import space.kscience.tables.*
import java.net.URL
import java.nio.file.Path
import kotlin.io.path.*

public fun SvHandler.Companion.readTable(
    source: CharSequence,
    valueSeparator: String,
    lineSeparator: String = "\n"
) : RowTable<Any> {
    val headers = source
        .split(lineSeparator)
        .first()
        .split(valueSeparator)
        .map { ColumnHeader(it.trim(), ValueType.STRING) }

    val rows = source.split(lineSeparator).filter { it != "" }.drop(1).map {
        MapRow(
            it.split(valueSeparator)
                .mapIndexed{ i, v -> headers[i].name to v.trim() }.toMap()
        )
    }

    return RowTable(headers = headers, rows = rows)
}

public fun SvHandler.Companion.readTable(
    source: Path,
    valueSeparator: String
) : RowTable<Any> {

    val headers = source
        .readLines()
        .first()
        .split(valueSeparator)
        .map { ColumnHeader(it.trim(), ValueType.STRING) }

    val rows = source.readLines().filter { it != "" }.drop(1).map {
        MapRow(
            it.split(valueSeparator)
                .mapIndexed { i, v -> headers[i].name to v.trim() }.toMap()
        )
    }

    return RowTable(headers = headers, rows = rows)
}

public fun SvHandler.Companion.readTable(
    source: URL,
    valueSeparator: String,
) : RowTable<Any> {
    return this.readTable(source.readText(), valueSeparator = valueSeparator)
}

public fun SvHandler.Companion.readCsvTable(source: CharSequence): RowTable<Any> = readTable(source, valueSeparator = ", ")
public fun SvHandler.Companion.readCsvTable(source: Path): RowTable<Any> = readTable(source, valueSeparator = ", ")
public fun SvHandler.Companion.readCsvTable(source: URL): RowTable<Any> = readTable(source, valueSeparator = ", ")

public fun SvHandler.Companion.readTsvTable(source: CharSequence): RowTable<Any> = readTable(source, valueSeparator = "\t")
public fun SvHandler.Companion.readTsvTable(source: Path): RowTable<Any> = readTable(source, valueSeparator = "\t")
public fun SvHandler.Companion.readTsvTable(source: URL): RowTable<Any> = readTable(source, valueSeparator = "\t")

public fun SvHandler.Companion.readPsvTable(source: CharSequence): RowTable<Any> = readTable(source, valueSeparator = "|")
public fun SvHandler.Companion.readPsvTable(source: Path): RowTable<Any> = readTable(source, valueSeparator = "|")
public fun SvHandler.Companion.readPsvTable(source: URL): RowTable<Any> = readTable(source, valueSeparator = "|")

public fun SvHandler.Companion.renderTableToString(
    table: RowTable<Any>,
    valueSeparator: String = " ",
    lineSeparator: String = "\n"
) : String {
    return table.headers.map { it.name }.joinToString(separator = valueSeparator) +
            lineSeparator +
            table.rows.map { row ->
                table.headers.map { row[it] }.joinToString(separator = valueSeparator)
            }.joinToString(separator = lineSeparator)
}

public fun SvHandler.Companion.renderTableToCsvString(table: RowTable<Any>): String =
    renderTableToString(table, valueSeparator = ", ")
public fun SvHandler.Companion.renderTableToTsvString(table: RowTable<Any>): String =
    renderTableToString(table, valueSeparator = "\t")
public fun SvHandler.Companion.renderTableToPsvString(table: RowTable<Any>): String =
    renderTableToString(table, valueSeparator = " | ")

public fun SvHandler.Companion.saveTable(
    table: RowTable<Any>,
    path: Path,
    valueSeparator: String,
    lineSeparator: String = "\n"
) { path.writeText(this.renderTableToString(table, valueSeparator, lineSeparator)) }

public fun SvHandler.Companion.saveTableToCsv(table: RowTable<Any>, path: Path): Unit = saveTable(table, path, valueSeparator = ", ")
public fun SvHandler.Companion.saveTableToTsv(table: RowTable<Any>, path: Path): Unit = saveTable(table, path, valueSeparator = "\t")
public fun SvHandler.Companion.saveTableToPsv(table: RowTable<Any>, path: Path): Unit = saveTable(table, path, valueSeparator = " | ")
