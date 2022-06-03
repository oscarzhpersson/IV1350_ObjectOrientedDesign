// Package declarations.
package com.opers.iv1350.view;

// Import declarations.
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the View class.
 */
public class ViewTest
{
    
    private View view;
    private PrintStream orgSysOut;
    private ByteArrayOutputStream printoutBuffer;
    
    /**
     * Sets up a new clean-slate controller before each test.
     */
    @BeforeEach
    public void setUp()
    {
        try
        {
            view = new View();   
        }
        catch (IOException exception)
        {
            System.out.println("The view could not be created. An exception was thrown.");
            exception.printStackTrace();
        }

        printoutBuffer = new ByteArrayOutputStream();

        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        orgSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    /**
     * Tears down loose ends after testing execution.
     */
    @AfterEach
    public void tearDown()
    {
        printoutBuffer = null;
        System.setOut(orgSysOut);
    }

    /**
     * Runs test checking if the fake execution runs properly.
     */
    @Test
    public void testFakeExecution()
    {
        view.fakeExecution();

        String printOut = printoutBuffer.toString();

        assertTrue(printOut.contains("Starts the sale"), "The View did not initialise correctly.");
    }

}
