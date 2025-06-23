package io.ravenzip.ruvilet.function

import io.ravenzip.ruvilet.model.FlowNotification
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion

fun <T> Flow<T>.materialize(): Flow<FlowNotification<T>> =
    this.map<T, FlowNotification<T>> { value -> FlowNotification.Next(value) }
        .catch { error -> emit(FlowNotification.Error(error)) }
        .onCompletion { cause ->
            if (cause == null) {
                emit(FlowNotification.Complete)
            }
        }
