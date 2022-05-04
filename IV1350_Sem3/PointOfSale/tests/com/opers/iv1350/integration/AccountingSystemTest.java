// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import org.junit.jupiter.api.*;
import com.opers.iv1350.model.Purchase;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the Accounting System class.
 */
public class AccountingSystemTest
{

    private AccountingSystem sys;
    
    /**
     * Sets up a new clean-slate Accounting System before each test.
     */
    @BeforeEach
    public void setUp ()
    {
        sys = new AccountingSystem();
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
     * Tests the logSale() function with a valid input by logging a purchase, checking if it was logged correctly.
     */
    @Test
    public void testLogSaleValid ()
    {
        Purchase purchase = new Purchase();
        InventorySystem inventory = new InventorySystem();

        purchase.updatePurchase(inventory.fetchItemData("1"), 1);

        sys.logSale(purchase);

        assertTrue(sys.accessLogByIndex(0) != null, "The item was not logged when it should have been");
    }

    /**
     * Tests the logSale() function with an invalid input. This is done by using a null value as a parameter, seeing if the function logs the value.
     */
    @Test
    public void testLogSaleInvalid ()
    {
        sys.logSale(null);
        
        assertFalse(sys.accessLogByIndex(0) != null, "The logSale function accepted a null input.");
    }

}
