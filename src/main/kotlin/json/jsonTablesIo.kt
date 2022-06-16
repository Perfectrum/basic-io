package json

import kotlinx.serialization.json.*
import space.kscience.dataforge.values.ValueType
import space.kscience.tables.*
import java.net.URL
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText

public fun JsonHandler.Companion.readTable(source: JsonArray) : RowTable<Any> {
    val headers = source.first().jsonObject.keys.map {
        ColumnHeader(it, ValueType.STRING)
    }

    val rows = source.map { element ->
        MapRow(
            element.jsonObject.entries.map {
                it.key to it.value.toString().drop(1).dropLast(1)
            }.toMap()
        )
    }

    return RowTable(headers = headers, rows = rows)
}

public fun JsonHandler.Companion.readTable(source: CharSequence) : RowTable<Any> = readTable(Json.parseToJsonElement(source.toString()).jsonArray)

public fun JsonHandler.Companion.readTable(source: Path) : RowTable<Any> = readTable(source.readText())

public fun JsonHandler.Companion.readTable(source: URL) : RowTable<Any> = readTable(source.readText())

public fun JsonHandler.Companion.renderTable(table: Table<Any>) : JsonArray =
    buildJsonArray {
        table.rows.forEach { row ->
            addJsonObject {
                table.headers.forEach {
                    put(it.name, row[it.name].toString())
                }
            }
        }
    }

public fun JsonHandler.Companion.saveTable(table: Table<Any>, path: Path) {
    path.writeText( this.renderTable(table).toString() )
}