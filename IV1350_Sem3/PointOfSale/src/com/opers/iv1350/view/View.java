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

        controller.startSale();
        controller.enteritem("1", 1);

        controller.registerPayment(50);

        controller.printReceipt();
        controller.endSale();
    }

}
