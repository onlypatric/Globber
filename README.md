# Globber Java Logging Library

A simple Java logging library that supports different log levels and allows customization of the output format.

## Author
Pintescul Patric

## Version
1.0.0

## GitHub Repository
[https://github.com/onlypatric](https://github.com/onlypatric)

## Usage

The `Globber` class provides methods to set the log level and output format, as well as to log messages.

### Set Log Level

```java
public static void setLogLevel(int level)
```

Sets the log level for filtering the log messages. The level parameter specifies the log level to set.

### Set Output Format
```java
public static void setOutputFormat(String format)
```
Sets the output format for formatting the log messages. The format parameter specifies the output format to set. The following placeholders can be used in the format string:

 - `{LOGTYPE}`: Replaced with the log type.
 - `{DATE}`: Replaced with the current date.
 - `{TIME}`: Replaced with the current time.
 - `{MESSAGE}`: Replaced with the log message.

### Log message
```java
public static void log(int level, String message)
```
Logs a message with the given log level and message. The level parameter specifies the log level of the message, and the message parameter contains the message to log.

### Log Levels
The following log levels are supported:

- 60: FATAL
- 50: CRITICAL
- 40: ERROR
- 30: WARNING
- 20: DEBUG
- 10: INFO
- 0: STATUS

### Output Formatting
The default output format is as follows:

```java
{LOGTYPE} [{DATE} {TIME}]: {MESSAGE}
```
You can customize the output format by calling the `setOutputFormat` method and providing a format string with the desired placeholders.

### Examples
```java
// Set log level to DEBUG
Globber.setLogLevel(20);

// Set custom output format
Globber.setOutputFormat("{DATE} - {LOGTYPE}: {MESSAGE}");

// Log an error message
Globber.log(40, "An error occurred");
```

