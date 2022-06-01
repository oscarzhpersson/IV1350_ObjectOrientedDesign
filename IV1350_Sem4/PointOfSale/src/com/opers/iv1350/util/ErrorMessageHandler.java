package com.opers.iv1350.util;

// Import dependencies.
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Class representing an object which shows error messages to the user.
 */
public class ErrorMessageHandler
{

    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();

    private ErrorMessageHandler(){}

    /**
     * @return Returns the only instance of the error message handler class.
     */
    public static ErrorMessageHandler getErrorMessageHandler()
    {
        return ERROR_MESSAGE_HANDLER;
    }
    
    /**
     * Displays a composite error message for the user.
     * @param String msg The error message.
     */
    public void showMessage(String msg)
    {
        StringBuilder errorMsgBuilder = new StringBuilder(); errorMsgBuilder.append(currentTime()); errorMsgBuilder.append(", ERROR: ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }

    private String currentTime()
    {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        return current.format(formatter);
    }

}
