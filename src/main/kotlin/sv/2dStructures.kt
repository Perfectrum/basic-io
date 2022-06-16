package sv

import space.kscience.kmath.nd.Structure2D
import java.net.URL
import java.nio.file.Path

fun SvHandler.Companion.read2dStructure(
    source: CharSequence,
    valueSeparator: String,
    lineSeparator: String = "\n"
) : Structure2D<Any> { TODO() }

fun SvHandler.Companion.read2dStructure(
    source: Path,
    valueSeparator: String = ", ",
    lineSeparator: String = "\n",
    skipLines: Int = 0
) : Structure2D<Any> { TODO() }

fun SvHandler.Companion.read2dStructure(
    source: URL,
    valueSeparator: String = ", ",
    lineSeparator: String = "\n",
    skipLines: Int = 0
) : Structure2D<Any> { TODO() }

fun SvHandler.Companion.readCsvTo2dStructure(source: CharSequence) =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = ",")

fun SvHandler.Companion.readCsvTo2dStructure(source: Path, skipLines: Int = 0) =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = ",", skipLines = skipLines)

fun SvHandler.Companion.readCsvTo2dStructure(source: URL, skipLines: Int = 0) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = ",", skipLines = skipLines)

fun SvHandler.Companion.readTsvTo2dStructure(source: CharSequence) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = "\t")

fun SvHandler.Companion.readTsvTo2dStructure(source: Path, skipLines: Int = 0) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = "\t", skipLines = skipLines)

fun SvHandler.Companion.readTsvTo2dStructure(source: URL, skipLines: Int = 0) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = "\t", skipLines = skipLines)

fun SvHandler.Companion.readPsvTo2dStructure(source: CharSequence) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = "|")

fun SvHandler.Companion.readPsvTo2dStructure(source: Path, skipLines: Int = 0) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = "|", skipLines = skipLines)

fun SvHandler.Companion.readPsvTo2dStructure(source: URL, skipLines: Int = 0) : Structure2D<Any> =
    SvHandler.Companion.read2dStructure(source = source, valueSeparator = "|", skipLines = skipLines)

fun save2dStructure(
    data: Iterable<Any>,
    path: Path,
    valueSeparator: String,
    lineSeparator: String = "\n"
) { TODO() }

fun save2dStructureToCsv(data: Iterable<Any>, path: Path) = save2dStructure(data, path, valueSeparator = ",")
fun save2dStructureToTsv(data: Iterable<Any>, path: Path) = save2dStructure(data, path, valueSeparator = "\t")
fun save2dStructureToPsv(data: Iterable<Any>, path: Path) = save2dStructure(data, path, valueSeparator = "|")
