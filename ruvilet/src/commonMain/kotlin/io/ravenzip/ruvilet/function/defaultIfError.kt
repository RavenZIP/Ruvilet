package io.ravenzip.ruvilet.function

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch

fun <T> Flow<T>.defaultIfError(transform: suspend FlowCollector<T>.() -> T): Flow<T> =
    this.catch { emit(transform()) }
