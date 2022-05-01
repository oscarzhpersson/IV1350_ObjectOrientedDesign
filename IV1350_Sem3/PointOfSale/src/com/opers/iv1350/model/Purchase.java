// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import com.opers.iv1350.model.Receipt;
import com.opers.iv1350.dto.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

public class Purchase
{

    private Receipt receipt;

    // Values.
    private LocalTime timeOfSale;
    private float change;

    private ArrayList<ItemDTO> purchasedItems = new ArrayList<ItemDTO>();
    
    /**
     * Constructor for the Purchase object class.
     */
    public Purchase ()
    {
        receipt = new Receipt();
        change = 0.0f;

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

    /**
     * Calculates the total price within the purchasedItem list.
     * 
     * @param includeVat Should VAT be included in the total?
     * @return The running total of the items.
     */
    private float calculateTotal (boolean includeVat)
    {
        float total = 0.0f;

        for (ItemDTO itemDTO : purchasedItems)
        {
            total += itemDTO.getPrice() + itemDTO.getPrice() * ((itemDTO.getVat() / 100) * (includeVat ? 1 : 0));
        }

        return total;
    }

    /**
     * 
     * Registers a payment of the current open purchase.
     * 
     * @param amount The amount which was paid.
     */
    public void registerPayment(float amount)
    {
        float total = getTotal();

        change = total - amount;
    }

    /**
     * Getter function for the formatted receipt of the purchase.
     */
    public String getReceipt ()
    {
        receipt.setPurchase(this);
        return receipt.toString();
    }

    /**
     * 
     * Getter function for the total of the purchase including VAT.
     * 
     * @return The total cost of the purchase.
     */
    public float getTotal ()
    {
        return calculateTotal(true);
    }

    /**
     * 
     * Getter function for the time of the sale.
     * 
     * @return The time of the purchase.
     */
    public LocalTime getTimeOfSale ()
    {
        return timeOfSale;
    }

    /**
     * 
     * Getter function for the items.
     * 
     * @return The items within the purchase.
     */
    public ArrayList<ItemDTO> getItems ()
    {
        return purchasedItems;
    }

    /**
     * 
     * Getter function for the change of the purchase.
     * 
     * @return The change of the purchase.
     */
    public float getChange ()
    {
        return change;
    }

    /**
     *  Override for the toString() function.
     *  Prints the values of the Purchase object.
     */
    @Override
    public String toString ()
    {
        return String.format("Total: %f, Total VAT incl.: %f", calculateTotal(false), calculateTotal(true));
    }
}
