// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.util.ErrorLogHandler;
import com.opers.iv1350.integration.*;
import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.dto.ItemsSummaryDTO;
import com.opers.iv1350.integration.NoSuchItemException;

import java.io.IOException;
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
    private ErrorLogHandler errorLogHandler;

    // Reference variables.
    private Purchase purchase;
    private ArrayList<TotalRevenueObserver> totalRevenueObservers = new ArrayList<TotalRevenueObserver>();

    /**
     * Constructor for the Controller object. Sets the initial values.
     */
    public Controller () throws IOException
    {
        this.inventorySystem = new InventorySystem();
        this.accountingSystem = new AccountingSystem();
        this.printer = new Printer();
        this.errorLogHandler = new ErrorLogHandler();
    }

    /**
     * Creates a new Purchase object. Resets the currently stored purchase, via replacement.
     */
    public void startSale ()
    {
        purchase = new Purchase();

        for (TotalRevenueObserver observer : totalRevenueObservers)
        {
            purchase.addObserver(observer);
        }
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
    public ItemsSummaryDTO enterItem(String id, int quantity) throws OperationFailedException
    {
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
        catch (NoSuchItemException exception)
        {
            throw new OperationFailedException("The scanned item could not be registered.", exception);
        }
        catch (Exception exception)
        {
            errorLogHandler.logException(exception);
            throw new OperationFailedException("The scanned item could not be registered.", exception);
        }
    }

    /**
     * The provided observer will be notified of events regarding a change in the total revenue.
     * @param observer The observer to notify.
     */
    public void addObserver (TotalRevenueObserver observer)
    {
        totalRevenueObservers.add(observer);
    }
}
