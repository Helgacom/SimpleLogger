# SimpleLogger

## О проекте

Система для логгирования, поддерживает следующие функции:

1. Логгирование сообщений разных уровней (DEBUG, INFO, WARN, ERROR).
2. Возможность конфигурирования логгеров (например, уровень логирования, формат сообщений, выходные потоки (консоль, файл и т.д.)).
3. Возможность добавления различных аппендеров (console appender, file appender).
4. Поддержка конфигурации через файл конфигурации.
5. Асинхронное логгирование (опционально)

## Примечания
- Использован подход TDD (Test-Driven Development)
- система построена по аналогии с log4j