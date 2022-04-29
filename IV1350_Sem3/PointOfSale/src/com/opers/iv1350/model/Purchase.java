// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import com.opers.iv1350.model.Payment;
import com.opers.iv1350.dto.itemDTO;
import java.time.LocalTime;

public class Purchase
{

    private Receipt receipt;
    private LocalTime timeOfSale;
    
    /**
     * 
     */
    public Purchase ()
    {
        receipt = new Receipt();

        setTimeOfSale();   
    }

    /**
     * Updates the internal representation of the time of the sale.
     */
    public void setTimeOfSale () // ! Should maybe be private?
    {
        timeOfSale = LocalTime.now();
    }

    /**
     * 
     * Updates this purchase by adding the item from the argument to its collected values.
     * 
     * @param item The item to add the properties from.
     */
    public void updatePurchase (itemDTO item)
    {

    }

}
