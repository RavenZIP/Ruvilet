package io.ravenzip.ruvilet.function

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

/**
 * Catches errors in the flow and replaces them with the specified recovery value.
 *
 * Example:
 * ```
 * flow {
 *     emit(1)
 *     emit(2)
 *     throw Exception("Error")
 * }.defaultIfError(-1)
 * .collect { println(it) }  //Output: 1, 2, -1
 * ```
 *
 * @param recoveryValue the value to be emitted when an error occurs
 * @return a new [Flow] that will emit [recoveryValue] instead of throwing an exception when an
 *   error occurs
 * @see [Русская документация](docs/ru/defaultIfError.md)
 */
inline fun <reified T> Flow<T>.defaultIfError(recoveryValue: T): Flow<T> =
    this.catch { emit(recoveryValue) }
