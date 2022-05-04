// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import com.opers.iv1350.model.Purchase;
import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.dto.ItemIndexDTO;

/**
 * Object representing the receipt in a transaction.
 * Handles all functionality relating to the receipt.
 * 
 * Serialiseable.
 */
public class Receipt
{

    private Purchase purchaseOfReceipt;

    /**
     * Constructor for the Receipt object class.
     */
    public Receipt ()
    {
        purchaseOfReceipt = null;
    }

    /**
     * Setter function setting the relevant purchase for this particular receipt object.
     * 
     * @param The purchase for which to print a receipt.
     */
    public void setPurchase(Purchase purchase)
    {
        purchaseOfReceipt = purchase;
    }

    /**
     *  Override for the toString() function.
     *  Prints the values of the Receipt object.
     */
    @Override
    public String toString()
    {
        String items = "";

        for (ItemIndexDTO itemIndex : purchaseOfReceipt.getItems())
        {
            ItemDTO item = itemIndex.getItem();
            items += item.getItemName() + " x" + itemIndex.getQuantity() + "\n";
        }

        return String.format("*** RECEIPT *** \n\n Time of sale: %s \n Items: \n %s \n Total: €%.2f \n Change: €%.2f", purchaseOfReceipt.getTimeOfSale().toString(), items, purchaseOfReceipt.getTotal(), purchaseOfReceipt.getChange());
    }
}
