package com.opers.iv1350.view;

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
