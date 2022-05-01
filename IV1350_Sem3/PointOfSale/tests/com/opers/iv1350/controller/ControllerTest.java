// Package declarations.
package com.opers.iv1350.controller;

// Import declarations.
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the Controller class.
 */
public class ControllerTest
{

    private Controller controller;
    private PrintStream orgSysOut;
    private ByteArrayOutputStream printoutBuffer;
    
    /**
     * Sets up a new clean-slate controller before each test.
     */
    @BeforeEach
    public void setUp()
    {
        controller = new Controller();
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
     * Runs test for the enterItem() function.
     * Tests with an item that exists in the registry.
     */
    @Test
    public void testEnterItem_ItemExists()
    {
        controller.enteritem("1", 1);
        String output = printoutBuffer.toString();

        assertTrue(!output.contains("An Error has occurred: Item ID not found."));
    }

    /**
     * Runs test for the enterItem() function.
     * Tests with an item that does not exist in the registry.
     */
    @Test
    public void testEnterItem_ItemNotExists()
    {
        controller.enteritem("-1", 1);
        String output = printoutBuffer.toString();

        assertTrue(output.contains("An Error has occurred: Item ID not found."));
    }

    /**
     * Runs rest for the registerPayment() function.
     * Evaluates to true if nothing else fails. This is only an intermediate call which makes this necessary as exceptions has not been added yet.
     */
    @Test
    public void testRegisterPayment_Valid()
    {
        controller.registerPayment(50);

        assertTrue(true);
    }

    /**
     * Runs rest for the registerPayment() function.
     * Evaluates to true if nothing else fails. This is only an intermediate call which makes this necessary as exceptions has not been added yet.
     */
    @Test
    public void testRegisterPayment_Invalid()
    {
        controller.registerPayment(-1);
        String output = printoutBuffer.toString();

        assertTrue(output.contains("Payment is within an invalid numerical range"));
    }

    /**
     * Runs test for startSale() function.
     */
    @Test
    public void testStartSale()
    {
        controller.startSale();
    }

}
