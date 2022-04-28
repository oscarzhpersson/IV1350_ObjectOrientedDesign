// Package declarations.
package com.opers.iv1350.controller;

// Import Declarations.
import com.opers.iv1350.model.*;
import com.opers.iv1350.view.View;



public class Controller
{
    
    private View view;
    private Model model;

    public Controller (View view)
    {
        this.view = view;
        this.model = view.model;
    }

    public void startSale ()
    {

        Purchase purchase = new Purchase();

    }

}
