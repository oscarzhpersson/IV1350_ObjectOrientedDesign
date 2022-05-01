// Package declarations.
package com.opers.iv1350.startup;

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
        View view = new View();
    }
}
