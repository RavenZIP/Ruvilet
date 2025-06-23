package io.ravenzip.ruvilet.function

import io.ravenzip.ruvilet.model.FlowNotification
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

fun <T> Flow<FlowNotification<T>>.dematerialize(): Flow<T> =
    this.transform { notification ->
        when (notification) {
            is FlowNotification.Next -> emit(notification.value)
            is FlowNotification.Error -> throw notification.error
            is FlowNotification.Complete -> return@transform
        }
    }
