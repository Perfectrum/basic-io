package sv

import space.kscience.dataforge.values.ValueType
import space.kscience.tables.ColumnHeader
import space.kscience.tables.RowTable
import space.kscience.tables.*
import java.net.URL
import java.nio.file.Path

public fun SvHandler.Companion.readTable(
    source: CharSequence,
    valueSeparator: String,
    lineSeparator: String = "\n"
) : RowTable<Any> {

    val headers = source
        .split(lineSeparator)
        .first()
        .split(valueSeparator)
        .map { ColumnHeader(it, ValueType.STRING) }

    val rows = source
        .split(lineSeparator)
        .drop(1)
        .map {
            MapRow(
                    it.split(valueSeparator)
                        .mapIndexed{ i, v ->
                            headers[i].name to v
                        }.toMap()
                )
        }

    return RowTable(
        headers = headers,
        rows = rows
    )
}

public fun SvHandler.Companion.readTable(
    source: Path,
    valueSeparator: String,
    lineSeparator: String = "\n",
    skipLines: Int = 0
) : RowTable<Any> { TODO() }

public fun SvHandler.Companion.readTable(
    source: URL,
    valueSeparator: String,
    lineSeparator: String = "\n",
    skipLines: Int = 0
) : RowTable<Any> { TODO() }

public fun SvHandler.Companion.readCsvTable(source: CharSequence) = readTable(source, valueSeparator = ",")
public fun SvHandler.Companion.readCsvTable(source: Path) = readTable(source, valueSeparator = ",")
public fun SvHandler.Companion.readCsvTable(source: URL) = readTable(source, valueSeparator = ",")

public fun SvHandler.Companion.readTsvTable(source: CharSequence) = readTable(source, valueSeparator = "\t")
public fun SvHandler.Companion.readTsvTable(source: Path) = readTable(source, valueSeparator = "\t")
public fun SvHandler.Companion.readTsvTable(source: URL) = readTable(source, valueSeparator = "\t")

public fun SvHandler.Companion.readPsvTable(source: CharSequence) = readTable(source, valueSeparator = "|")
public fun SvHandler.Companion.readPsvTable(source: Path) = readTable(source, valueSeparator = "|")
public fun SvHandler.Companion.readPsvTable(source: URL) = readTable(source, valueSeparator = "|")

public fun SvHandler.Companion.renderTableToString(
    table: RowTable<Any>,
    valueSeparator: String = " ",
    lineSeparator: String = "\n"
) : String {
    return table.headers.map { it.name }.joinToString (separator = valueSeparator) +
            lineSeparator +
            table.rows.mapIndexed { i, row ->
                table.headers.map { row[it] }.joinToString(separator = valueSeparator)
            }.joinToString(separator = lineSeparator)
}

public fun SvHandler.Companion.renderTableToCsvString(table: RowTable<Any>) =
    renderTableToString(table, valueSeparator = ",")
public fun SvHandler.Companion.renderTableToTsvString(table: RowTable<Any>) =
    renderTableToString(table, valueSeparator = "\t")
public fun SvHandler.Companion.renderTableToPsvString(table: RowTable<Any>) =
    renderTableToString(table, valueSeparator = "|")

public fun SvHandler.Companion.saveTable(
    table: Table<Any>,
    path: Path,
    valueSeparator: String,
    lineSeparator: String = "\n"
) : Table<Any> { TODO() }

public fun SvHandler.Companion.saveTableToCsv(table: Table<Any>, path: Path) = saveTable(table, path, valueSeparator = ",")
public fun SvHandler.Companion.saveTableToTsv(table: Table<Any>, path: Path) = saveTable(table, path, valueSeparator = "\t")
public fun SvHandler.Companion.saveTableToPsv(table: Table<Any>, path: Path) = saveTable(table, path, valueSeparator = "|")
