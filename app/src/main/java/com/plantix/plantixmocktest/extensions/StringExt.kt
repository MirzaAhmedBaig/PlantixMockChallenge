package com.plantix.plantixmocktest.extensions

import java.util.*

fun String.newCapitalize(): String {
    return replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}