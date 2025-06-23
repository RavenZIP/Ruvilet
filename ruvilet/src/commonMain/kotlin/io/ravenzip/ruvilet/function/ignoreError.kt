package io.ravenzip.ruvilet.function

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.emptyFlow

/**
 * Catches errors in the flow and terminates the stream on error without emitting any values.
 *
 * Example:
 * ```
 * flow {
 *     emit(1)
 *     emit(2)
 *     throw RuntimeException("Error")
 * }.ignoreError()
 * .collect { println(it) }  // Output: 1, 2
 * ```
 *
 * @return a new [Flow] that completes normally on error
 * @see [Русская документация](docs/ru/ignoreError.md)
 */
fun <T> Flow<T>.ignoreError(): Flow<T> = this.catch { emitAll(emptyFlow()) }
