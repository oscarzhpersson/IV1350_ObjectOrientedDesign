// Package declarations.
package com.opers.iv1350.integration;

/**
 * Representation of printer system access point.
 */
public class Printer
{

    /**
     * Prints the associated receipts of the current purchase.
     * 
     * @param purchase The purchase string of which to print.
     */
    public void printReceipt(String purchase)
    {
        
        if (purchase == null)
        {
            System.out.println("The object purchase can not be null");
            return;
        }

        System.out.println(purchase);
    }

}
