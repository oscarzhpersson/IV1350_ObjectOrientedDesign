// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.integration.*;
import com.opers.iv1350.dto.itemDTO;



public class Controller
{

    // External systems.
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer printer;

    // Reference variables.
    private Purchase purchase;

    public Controller ()
    {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        printer = new Printer();
    }

    /**
     * Creates a new Purchase object. Resets the currently stored purchase, via replacement.
     */
    public void startSale ()
    {
        purchase = new Purchase();
    }

    /**
     * 
     * @param id
     * @param quantity
     */
    public void enteritem(int id, int quantity)
    {

        itemDTO item = inventorySystem.fetchItemData(id);

        // TODO: Maybe change this error implementation.
        if (item == null)
        {
            System.out.println("An Error has occurred: Item ID not found.");
            return;
        }

        inventorySystem.updateInventory(id, quantity);

        // TODO: Check if purchase exists. Otherwise throw an error.

        purchase.updatePurchase(item);

        // Feedback to the view.
        // TODO: Should this be here?
        System.out.println(item.toString());

    }

}
