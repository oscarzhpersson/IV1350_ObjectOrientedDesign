// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import org.junit.jupiter.api.*;
import com.opers.iv1350.dto.ItemDTO;

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
            fail("An item which should exist was not found.");
            exception.printStackTrace();
        }
    }

    /**
     * Tests the fetchItemData() function using an invalid input.
     */
    @Test
    public void fetchItemDataTestInvalid ()
    {
        ItemDTO item = null;

        try
        {
            item = sys.fetchItemData("FEL");
            fail("An item with id that should not exist was found in the inventory system.");
        }
        catch(NoSuchItemException exception)
        {
            assertFalse(item != null, "An item was found, even though none should exist.");
            assertTrue(exception.getMessage().contains("does not correspond to an existing item"));
        }
    }

    /**
     * Tests the database connection error exception.
     */
    @Test
    public void databaseConnectionTest ()
    {
        try
        {
            sys.fetchItemData("DatabaseConnection");
            fail("The component could connect to the non-existing database");
        }
        catch (DatabaseConnectionErrorException exception)
        {
            assertTrue(exception.getMessage().contains("A connection could not be established to the database"));
        }
        catch (NoSuchItemException exception)
        {
            fail("The wrong exception was caught. Program should not be able to proceed to this point.");
        }
    }

}
