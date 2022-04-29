// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import com.opers.iv1350.model.Payment;
import com.opers.iv1350.dto.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

public class Purchase
{

    private Receipt receipt;
    private LocalTime timeOfSale;

    private ArrayList<ItemDTO> purchasedItems = new ArrayList<ItemDTO>();
    
    /**
     * Constructor for the Purchase object class.
     */
    public Purchase ()
    {
        receipt = new Receipt();

        setTimeOfSale();   
    }

    /**
     * Updates the internal representation of the time of the sale.
     */
    private void setTimeOfSale ()
    {
        timeOfSale = LocalTime.now();
    }

    /**
     * 
     * Updates this purchase by adding the item from the argument to its collected values.
     * 
     * @param item The item to add the properties from.
     * @param quantity The amount of items to add to the purchase.
     */
    public void updatePurchase (ItemDTO item, int quantity)
    {
        for (int i = 0; i < quantity; i++)
            purchasedItems.add(item);

        //TODO: Collect the rest of the information?

    }
}
