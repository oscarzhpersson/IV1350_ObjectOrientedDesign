// Package declarations.
package com.opers.iv1350.view;

// Import Declarations.
import com.opers.iv1350.model.Model;
import com.opers.iv1350.controller.Controller;

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
    }

}
