package io.ravenzip.ruvilet.function

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

inline fun <reified T> Flow<T>.defaultIfError(recoveryValue: T): Flow<T> =
    this.catch { emit(recoveryValue) }
