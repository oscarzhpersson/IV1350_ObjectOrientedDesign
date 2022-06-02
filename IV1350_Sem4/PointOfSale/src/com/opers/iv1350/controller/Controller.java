// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.util.ErrorMessageHandler;
import com.opers.iv1350.integration.*;
import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.dto.ItemsSummaryDTO;
import com.opers.iv1350.integration.NoSuchItemException;
import com.opers.iv1350.integration.DatabaseConnectionErrorException;

import java.util.ArrayList;


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
     * @return A summary DTO containing relevant information for the View. If the item is not found, an alibi is returned, null.
     */
    public ItemsSummaryDTO enterItem(String id, int quantity)
    {

        // TODO
        /*if (id == "DatabaseConnection")
        {
            throw new DatabaseConnectionErrorException();
        }*/

        try
        {
            ItemDTO item = inventorySystem.fetchItemData(id);
            ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

            inventorySystem.updateInventory(id, quantity);

            purchase.updatePurchase(item, quantity);

            for (int i = 0; i < quantity; i++)
                items.add(item);

            ItemsSummaryDTO summary = new ItemsSummaryDTO(items, quantity, purchase);

            return summary;
        }
        catch(NoSuchItemException exception)
        {
            ErrorMessageHandler.getErrorMessageHandler().showMessage("An item with the id: " + id + " could not be found.");
        }

        // TODO: What to do when nothing is to be returned?
        return null;
    }
}
