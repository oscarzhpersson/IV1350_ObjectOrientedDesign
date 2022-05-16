// Package declarations.
package com.opers.iv1350.view;

// Import Declarations.
import com.opers.iv1350.controller.Controller;

/**
 * The view class in adherence to the MVC (Model, View, Controller) programming architecture.
 */
public class View
{

    private Controller controller;
    
    /**
     * Constructor for the View object class.
     */
    public View ()
    {
        controller = new Controller();
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

        System.out.println("\n\n");
        System.out.print("→ An item has been scanned");
        System.out.println("\n\n");
        System.out.println(controller.enterItem("1", 1).toString());

        System.out.println("\n\n");
        System.out.print("→ Two of the same items have been scanned");
        System.out.println("\n\n");
        System.out.println(controller.enterItem("1", 2).toString());

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
