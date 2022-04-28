// Package declarations.
package com.opers.iv1350.view;

// Import Declarations.
import com.opers.iv1350.model.Model;
import com.opers.iv1350.controller.Controller;

public class View
{

    public Model model; //! Should this be public. Should I re-route this?
    private Controller controller;
    
    public View (Model model)
    {
        this.model = model;

        controller = new Controller();
    }

}
