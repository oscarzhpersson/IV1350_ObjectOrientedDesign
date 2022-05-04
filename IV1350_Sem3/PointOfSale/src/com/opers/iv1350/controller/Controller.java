// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.integration.*;
import com.opers.iv1350.dto.ItemDTO;


/**
 * The controller class in adherence to the MVC (Model, View, Controller) programming architecture.
 */
public class Controller
{

    // External systems.
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer printer;

    // Reference variables.
    private Purchase purchase;

    /**
     * Constructor for the Controller object. Sets the initial values.
     */
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
     * Ends the sale, logging the information of the sale into the external accounting system.
     */
    public void endSale ()
    {
        accountingSystem.logSale(purchase);
    }

    /**
     * Prints the associated receipts of the current purchase.
     */
    public void printReceipt()
    {
        printer.printReceipt(purchase.getReceipt());
    }

    /**
     * Getter function for the Purchase object for the current purchase instance.
     * @return The current purchase instance.
     */
    public Purchase getPurchase ()
    {
        return purchase;
    }

    /**
     * 
     * Registers a payment of the current open purchase.
     * 
     * @param amount The amount which was paid.
     */
    public void registerPayment(float amount)
    {
        purchase.registerPayment(amount);
    }

    /**
     * 
     * Fetches the information of the scanned item.
     * Updates the balance of the item in the inventory.
     * 
     * @param id The ID of the item.
     * @param quantity The quantity of items which are to be entered.
     */
    public void enterItem(String id, int quantity)
    {

        ItemDTO item = inventorySystem.fetchItemData(id);

        if (item == null)
        {
            return;
        }

        inventorySystem.updateInventory(id, quantity);

        purchase.updatePurchase(item, quantity);

        // Feedback to the view.
        System.out.println(item.toString() + " x" + quantity);
        System.out.println(purchase.toString());
    }
}
