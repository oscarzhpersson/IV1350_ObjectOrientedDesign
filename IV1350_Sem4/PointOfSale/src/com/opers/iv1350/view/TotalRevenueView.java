// Package declarations.
package com.opers.iv1350.view;

// Import declarations.
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import com.opers.iv1350.model.TotalRevenueObserver;

public class TotalRevenueView implements TotalRevenueObserver
{
    
    float totalIncome;

    /**
     * Constructor creating a new instance of TotalRevenueView().
     */
    public TotalRevenueView ()
    {
        this.totalIncome = 0.0f;
    }

    @Override
    public void totalRevenueUpdate(float difference)
    {
        totalIncome += difference;

        System.out.print("___________________________________________________________________");
        System.out.println(currentTime() + " → The total revenue after the current transaction is: €" + totalIncome);
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
