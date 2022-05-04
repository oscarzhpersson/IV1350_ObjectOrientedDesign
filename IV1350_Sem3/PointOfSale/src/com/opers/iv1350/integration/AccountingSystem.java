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
