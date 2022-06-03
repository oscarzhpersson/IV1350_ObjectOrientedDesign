// Package declarations.
package com.opers.iv1350.startup;

import java.io.IOException;

// Import declarations.
import com.opers.iv1350.view.View;

/**
 * Boot sequence for the entire application. Contains the method which initialises the system.
 */
public class Main {

    /**
     * 
     * The main method used to start the application.
     * 
     * @param args Command line arguments, should such be included.
     */
    public static void main(String[] args)
    {
        try
        {
            View view = new View();

            view.fakeExecution();
        }
        catch (IOException exception)
        {
            System.out.println("Could not start the application");
            exception.printStackTrace();
        }
    }
}
