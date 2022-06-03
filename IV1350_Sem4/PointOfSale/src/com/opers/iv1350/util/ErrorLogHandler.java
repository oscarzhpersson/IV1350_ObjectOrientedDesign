package com.opers.iv1350.util;

// Import declaration.
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ErrorLogHandler
{
    private static final String LOG_FILE_NAME = "pos_errorlog.txt";

    private PrintWriter logger;

    /**
     * Constructor for the ErrorLogHandler object.
     * @throws IOException If an I/O error occurs.
     */
    public ErrorLogHandler() throws IOException
    {
        logger = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }

    /**
     * Function writing a log entry describing the thrown exception to file.
     * @param exception The exception to be logged.
     */
    public void logException(Exception exception)
    {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(currentTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logger.println(logMsgBuilder);

        exception.printStackTrace(logger);
    }

    /**
     * Returns the current date and time in a string format.
     * @return A string representing the current date and time.
     */
    private String currentTime()
    {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        return current.format(formatter);
    }

}
