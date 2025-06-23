# Класс: FlowNotification

## Описание

Материализованное представление событий `Flow`.

Используется в паре с операторами:

- [kotlinx.coroutines.flow.materialize] — преобразует `Flow<T>` в `Flow<FlowNotification<T>>`
- [kotlinx.coroutines.flow.dematerialize] — обратное преобразование.

## События

- [Next] — значение потока;
- [Error] — ошибка, завершившая поток;
- [Complete] — успешное завершение потока.