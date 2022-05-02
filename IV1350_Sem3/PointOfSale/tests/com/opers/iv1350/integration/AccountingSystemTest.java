// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.opers.iv1350.model.Purchase;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the Accounting System class.
 */
public class AccountingSystemTest
{

    private AccountingSystem sys;
    private PrintStream orgSysOut;
    private ByteArrayOutputStream printoutBuffer;
    
    /**
     * Sets up a new clean-slate Accounting System before each test.
     */
    @BeforeEach
    public void setUp ()
    {
        sys = new AccountingSystem();

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
     * Tests the logSale() function with a valid input.
     */
    @Test
    public void testLogSale_Valid ()
    {
        Purchase purchase = new Purchase();
        InventorySystem inventory = new InventorySystem();

        purchase.updatePurchase(inventory.fetchItemData("1"), 1);

        sys.logSale(purchase);
    }

    @Test
    public void testLogSale_Invalid ()
    {
        sys.logSale(null);

        String printOut = printoutBuffer.toString();
        
        assertTrue(printOut.contains("The object purchase can not be null"), "The logSale function accepted a null input.");
    }

}
