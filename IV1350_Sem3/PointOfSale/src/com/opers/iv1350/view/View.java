// Package declarations.
package com.opers.iv1350.view;

import com.opers.iv1350.controller.Controller;
// Import Declarations.
import com.opers.iv1350.model.Model;

public class View
{

    private Model model;
    private Controller controller;
    
    public View (Model model)
    {
        this.model = model;

        controller = new Controller();
    }

}
