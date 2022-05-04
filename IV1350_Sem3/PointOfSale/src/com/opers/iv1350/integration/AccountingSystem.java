// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import java.util.ArrayList;
import com.opers.iv1350.model.Purchase;

/**
 * Representation of external accounting system access point.
 */
public class AccountingSystem
{

    private ArrayList<Purchase> loggedPurchases;
    
    /**
     * Constructor for the AccountingSystem object. Sets the initial values.
     */
    public AccountingSystem ()
    {
        loggedPurchases = new ArrayList<Purchase>();
    }

    /**
     * Accesses a logged purchase by its index (ID) within the "database".
     * 
     * @param index The ID (index) of the logged purchase.
     * @return The purchase data from the logs.
     */
    public Purchase accessLogByIndex (int index)
    {
        if (index >= loggedPurchases.size())
            return null;

        return loggedPurchases.get(index);
    }

    /**
     * 
     * Logs the purchase into the accounting system.
     * 
     * @param purchase The purchase to be logged.
     */
    public void logSale (Purchase purchase)
    {

        if (purchase == null)
        {
            return;
        }

        loggedPurchases.add(purchase);
    }
}
