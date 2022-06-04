// Package declarations.
package com.opers.iv1350.util;

// Import declarations.
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import com.opers.iv1350.model.TotalRevenueObserver;

public class TotalRevenueFileOutput implements TotalRevenueObserver
{
    
    float totalIncome;
    private static final String REVENUELOG_FILE_NAME = "pos_revenueLog.txt";
    private PrintWriter logger;

    /**
     * Constructor creating a new instance of TotalRevenueFileOutput().
     * @throws IOException If an I/O error occurs.
     */
    public TotalRevenueFileOutput () throws IOException
    {
        this.totalIncome = 0.0f;

        logger = new PrintWriter(new FileWriter(REVENUELOG_FILE_NAME), true);
    }

    @Override
    public void totalRevenueUpdate(float difference)
    {
        totalIncome += difference;

        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(currentTime() + " → The total revenue after the current transaction is: €" + totalIncome + '\n');
        logMsgBuilder.append("___________________________________________________________________");
        logger.println(logMsgBuilder);
    }

    /**
     * Returns the current time as a string.
     * @return A string containing the current time.
     */
    private String currentTime()
    {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        return current.format(formatter);
    }
}
