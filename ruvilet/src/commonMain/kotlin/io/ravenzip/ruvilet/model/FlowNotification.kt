package io.ravenzip.ruvilet.model

/**
 * Materialized representation of [kotlinx.coroutines.flow.Flow] events.
 *
 * Designed to work with operators:
 * - [io.ravenzip.ruvilet.function.materialize] — converts Flow<T> into Flow<FlowNotification<T>>
 * - [io.ravenzip.ruvilet.function.dematerialize] — restores the original flow.
 *
 * Events:
 * - [Next] — emitted value;
 * - [Error] — termination error;
 * - [Complete] — successful completion.
 *
 * @see [Русская документация](docs/ru/FlowNotification.md)
 */
sealed class FlowNotification<out T> {
    data class Next<out T>(val value: T) : FlowNotification<T>()

    data class Error(val error: Throwable) : FlowNotification<Nothing>()

    data object Complete : FlowNotification<Nothing>()
}
