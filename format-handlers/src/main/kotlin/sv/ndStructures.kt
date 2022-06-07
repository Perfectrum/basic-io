package sv

import space.kscience.kmath.nd.NDStructure
import java.net.URL
import java.nio.file.Path

fun SvHandler.Companion.readNdStructure(
    source: CharSequence,
    valueSeparator: String,
    lineSeparator: String,
    layerSeparator: String
) : NDStructure<Any> { TODO() }

fun SvHandler.Companion.readNdStructure(
    source: Path,
    valueSeparator: String,
    lineSeparator: String,
    layerSeparator: String,
    skipLines: Int = 0
) : NDStructure<Any> { TODO() }

fun SvHandler.Companion.readNdStructure(
    source: URL,
    valueSeparator: String,
    lineSeparator: String,
    layerSeparator: String,
    skipLines: Int = 0
) : NDStructure<Any> { TODO() }

fun SvHandler.Companion.saveNdStructure(
    data: NDStructure<Any>,
    path: Path
) { TODO() }