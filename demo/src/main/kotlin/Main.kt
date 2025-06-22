package io.ravenzip

import io.ravenzip.ruvilet.function.filterNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking { flowOf(1, null).filterNull().collect { value -> println(value) } }
}
