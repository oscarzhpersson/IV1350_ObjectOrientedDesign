// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import com.opers.iv1350.model.Receipt;
import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.dto.ItemIndexDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Object representing the purchase in a transaction.
 * Handles all functionality relating to the purchase.
 */
public class Purchase
{
    private Receipt receipt;

    // Values.
    private LocalTime timeOfSale;
    private float change;

    private ArrayList<ItemIndexDTO> purchasedItems = new ArrayList<ItemIndexDTO>();
    private ArrayList<TotalRevenueObserver> totalRevenueObservers = new ArrayList<TotalRevenueObserver>();
    
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

        if (item == null)
        {
            return;
        }

        if (quantity < 0)
        {
            return;
        }

        for (ItemIndexDTO itemIndex : purchasedItems)
        {
            if (itemIndex.getItem().getId() == item.getId())
            {
                itemIndex.setQuantity(itemIndex.getQuantity() + quantity);
                return;
            }
        }

        purchasedItems.add(new ItemIndexDTO(item, quantity));

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

        for (ItemIndexDTO itemIndex: purchasedItems)
        {
            ItemDTO item = itemIndex.getItem();
            total += (item.getPrice() + item.getPrice() * ((item.getVat() * 0.01) * (includeVat ? 1 : 0))) * itemIndex.getQuantity();
        }

        return total;
    }

    /**
     * 
     * Registers a payment of the current open purchase.
     * Negative change implies insufficient payment.
     * 
     * @param amount The amount which was paid.
     */
    public void registerPayment(float amount)
    {
        if (amount < 0)
        {
            return;
        }

        if (amount < getTotal())
        {
            return;
        }

        float total = getTotal();

        change = amount - total;

        notifyObservers(total);
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
    public ArrayList<ItemIndexDTO> getItems ()
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
     * The provided observer will be notified of events regarding a change in the total revenue.
     * @param observer The observer to notify.
     */
    public void addObserver (TotalRevenueObserver observer)
    {
        totalRevenueObservers.add(observer);
    }

    /**
     * Notifies the listed observers of an event.
     * Invokes the function specified within the interface.
     * 
     * @param difference The difference in revenue (added or subtracted).
     * @param totalRevenue The total revenue after the change.
     */
    private void notifyObservers (float difference)
    {
        for (TotalRevenueObserver observer : totalRevenueObservers)
        {
            observer.totalRevenueUpdate(difference);    
        }
    }

    /**
     *  Override for the toString() function.
     *  Prints the values of the Purchase object.
     */
    @Override
    public String toString ()
    {
        return String.format("Total: %.2f, Total VAT incl.: %.2f", calculateTotal(false), calculateTotal(true));
    }
}
