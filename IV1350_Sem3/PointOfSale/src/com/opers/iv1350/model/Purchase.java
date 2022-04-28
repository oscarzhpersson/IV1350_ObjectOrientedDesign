// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import com.opers.iv1350.model.Payment;
import java.time.LocalTime;

public class Purchase
{

    private Receipt receipt; // ! Maybe needs to be public, but probably shouldn¨t be.
    private LocalTime timeOfSale;
    
    public Purchase ()
    {
        receipt = new Receipt();

        setTimeOfSale();   
    }

    public void setTimeOfSale () // ! Should maybe be private?
    {
        timeOfSale = LocalTime.now();
    }

}
