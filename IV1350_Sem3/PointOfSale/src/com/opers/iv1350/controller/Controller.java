// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.integration.*;



public class Controller
{

    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer printer;

    public Controller ()
    {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        printer = new Printer();
    }

    public void startSale ()
    {

        Purchase purchase = new Purchase();

    }

}
