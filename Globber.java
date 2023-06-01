import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple Java logging library that supports different log levels and allows customization of the output format.
 * 
 * @author Pintescul Patric
 * @version 1.0.0
 */
public class Globber {
    private static int logLevel;
    private static String outputFormat="{LOGTYPE} [{DATE} {TIME}]: {MESSAGE}";

    /**
     * Sets the log level for filtering the log messages.
     *
     * @param level the log level to set
     */
    public static void setLogLevel(int level) {
        logLevel = level;
    }

    /**
     * Sets the output format for formatting the log messages.
     * Available placeholders: {LOGTYPE}, {DATE}, {TIME}, {MESSAGE}
     *
     * @param format the output format to set
     */
    public static void setOutputFormat(String format) {
        outputFormat = format;
    }

    /**
     * Logs a message with the given log level.
     *
     * @param level   the log level of the message
     * @param message the message to log
     */
    public static void log(int level, String message) {
        if (level <= logLevel) {
            String logType = getLogTypeName(level);
            String formattedLogType = formatLogType(logType);
            String formattedMessage = outputFormat
                    .replace("{LOGTYPE}", getColoredLogType(formattedLogType))
                    .replace("{DATE}", getCurrentDate())
                    .replace("{TIME}", getCurrentTime())
                    .replace("{MESSAGE}", message);

            System.out.println(formattedMessage);
        }
    }

    // Get the log type name based on the log level
    private static String getLogTypeName(int level) {
        switch (level) {
            case 60:
                return "FATAL";
            case 50:
                return "CRITICAL";
            case 40:
                return "ERROR";
            case 30:
                return "WARNING";
            case 20:
                return "DEBUG";
            case 10:
                return "INFO";
            case 0:
                return "STATUS";
            default:
                return "";
        }
    }

    // Get the current date
    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    // Get the current time
    private static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(new Date());
    }

    // Format the log type by adding spaces if necessary
    private static String formatLogType(String logType) {
        StringBuilder sb = new StringBuilder(logType);
        int spacesToAdd = 9 - logType.length();
        for (int i = 0; i < spacesToAdd; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    // Add color to the log type based on the log level
    private static String getColoredLogType(String logType) {
        switch (logType) {
            case "FATAL    ":
                return "\u001B[45m " + logType + "\u001B[0m";
            case "CRITICAL ":
                return "\u001B[45m " + logType + "\u001B[0m";
            case "ERROR    ":
                return "\u001B[41m " + logType + "\u001B[0m";
            case "WARNING  ":
                return "\u001B[43m " + logType + "\u001B[0m";
            case "DEBUG    ":
                return "\u001B[46m " + logType + "\u001B[0m";
            case "INFO     ":
                return "\u001B[44m " + logType + "\u001B[0m";
            case "STATUS   ":
                return "\u001B[47m " + logType + "\u001B[0m";
            default:
                return logType;
        }
    }
}
