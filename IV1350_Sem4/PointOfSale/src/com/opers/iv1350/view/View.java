// Package declarations.
package com.opers.iv1350.view;

// Import Declarations.
import com.opers.iv1350.controller.Controller;
import com.opers.iv1350.controller.OperationFailedException;
import com.opers.iv1350.util.TotalRevenueFileOutput;

import java.io.IOException;
import com.opers.iv1350.view.ErrorMessageHandler;

/**
 * The view class in adherence to the MVC (Model, View, Controller) programming architecture.
 */
public class View
{

    private Controller controller;
    private ErrorMessageHandler errorMessageHandler;
    
    /**
     * Constructor for the View object class.
     */
    public View () throws IOException
    {
        controller = new Controller();
        errorMessageHandler = new ErrorMessageHandler();

        controller.addObserver(new TotalRevenueView());
        controller.addObserver(new TotalRevenueFileOutput());
    }

    /**
     * Fake execution for demonstration purposes.
     */
    public void fakeExecution()
    {
        System.out.println("\n\n");
        System.out.print("- Starts the sale");
        System.out.println("\n\n");
        controller.startSale();

        try
        {
            System.out.println("\n\n");
            System.out.print("→ An item has been scanned");
            System.out.println("\n\n");
            System.out.println(controller.enterItem("1", 1).toString());
        }
        catch(OperationFailedException exception)
        {
            errorMessageHandler.showMessage("The item could not be registered.");
        }

        try
        {
            System.out.println("\n\n");
            System.out.print("→ Two of the same items have been scanned");
            System.out.println("\n\n");
            System.out.println(controller.enterItem("1", 2).toString());
        }
        catch(OperationFailedException exception)
        {
            errorMessageHandler.showMessage("The item could not be registered.");
        }

        try
        {
            System.out.println("\n\n");
            System.out.print("→ A non-existant item has been entered");
            System.out.println("\n\n");
            System.out.println(controller.enterItem("NotAnItem", 1).toString());
        }
        catch(OperationFailedException exception)
        {
            errorMessageHandler.showMessage("The item could not be registered.");
        }

        try
        {
            System.out.println("\n\n");
            System.out.print("→ Fail the database connection");
            System.out.println("\n\n");
            System.out.println(controller.enterItem("DatabaseConnection", 1).toString());
        }
        catch(OperationFailedException exception)
        {
            errorMessageHandler.showMessage("The item could not be registered.");
        }

        System.out.println("\n\n");
        System.out.print("→ A payment has been registered");
        System.out.println("\n\n");
        controller.registerPayment(100);

        System.out.println("\n\n");
        System.out.print("→ Receipt is printed");
        System.out.println("\n\n");
        controller.printReceipt();

        System.out.println("\n\n");
        System.out.print("→ Ends the sale");
        System.out.println("\n\n");
        controller.endSale();
    }
}
