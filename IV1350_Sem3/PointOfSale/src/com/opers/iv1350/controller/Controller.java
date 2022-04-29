// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.integration.*;
import com.opers.iv1350.dto.ItemDTO;



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
     * Fetches the information of the scanned item.
     * Updates the balance of the item in the inventory.
     * 
     * @param id The ID of the item.
     * @param quantity The quantity of items which are to be entered.
     */
    public void enteritem(int id, int quantity)
    {

        ItemDTO item = inventorySystem.fetchItemData(id);

        // TODO: Maybe change this error implementation.
        if (item == null)
        {
            System.out.println("An Error has occurred: Item ID not found.");
            return;
        }

        inventorySystem.updateInventory(id, quantity);

        // TODO: Check if purchase exists. Otherwise throw an error.

        purchase.updatePurchase(item, quantity);

        // Feedback to the view.
        // TODO: Should this be here?
        System.out.println(item.toString());

    }

}
