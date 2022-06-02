// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import org.junit.jupiter.api.*;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the InventorySystem class.
 */
public class InventorySystemTest
{

    private InventorySystem sys;

    /**
     * Sets up a new clean-slate Accounting System before each test.
     */
    @BeforeEach
    public void setUp ()
    {
        sys = new InventorySystem();
    }

    /**
     * Tears down loose ends after testing execution.
     */
    @AfterEach
    public void tearDown()
    {
        sys = null;
    }

    /**
     * Tests the fetchItemData() function using a valid input.
     */
    @Test
    public void fetchItemDataTestValid ()
    {
        try
        {
            assertTrue(sys.fetchItemData("1") != null, "The item could not be found, even though it should exist.");
        }
        catch(NoSuchItemException exception)
        {
            // TODO: Add the catch clause for the exception.
            exception.printStackTrace();
        }
    }

    /**
     * Tests the fetchItemData() function using an invalid input.
     */
    @Test
    public void fetchItemDataTestInvalid ()
    {
        try
        {
            assertFalse(sys.fetchItemData("FEL") != null, "An item was found, even though none should exist.");
        }
        catch(NoSuchItemException exception)
        {
            // TODO: Add the catch clause for the exception.
            exception.printStackTrace();
        }
    }

}
