// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.integration.InventorySystem;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testinc class for the Purchase class.
 */
public class PurchaseTest
{
    private Purchase purchase;
    private InventorySystem inventory;
    private PrintStream orgSysOut;
    private ByteArrayOutputStream printoutBuffer;
    
    /**
     * Sets up a new clean-slate controller before each test.
     */
    @BeforeEach
    public void setUp()
    {
        purchase = new Purchase();
        inventory = new InventorySystem();
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
     * Tests the function which registers a payent function and calculates change, registerPayment(), using a valid payment.
     */
    @Test
    public void testRegisterPayment_Valid()
    {
        ItemDTO item = inventory.fetchItemData("1");
        purchase.updatePurchase(item, 1);

        purchase.registerPayment(Integer.MAX_VALUE);
    }

    /**
     * Tests the function which registers a payment function and calculates change, registerPayment(), using an invalid amount.
     */
    @Test
    public void testRegisterPayment_Invalid()
    {
        ItemDTO item = inventory.fetchItemData("1");

        purchase.updatePurchase(item, 1);
        purchase.registerPayment(-1);

        String output = printoutBuffer.toString();

        assertTrue(output.contains("Payment is within an invalid numerical range"), "The registerpayment function accepted an invalid amount.");
    }

    /**
     * Tests the function which registers a payment function and calculates change, registerPayment(), using an insufficient amount.
     */
    @Test
    public void testRegisterPayment_Insufficient()
    {
        ItemDTO item = inventory.fetchItemData("1");

        purchase.updatePurchase(item, 1);
        purchase.registerPayment(1);

        String output = printoutBuffer.toString();

        assertTrue(output.contains("The payment is insufficient"), "The registerpayment function accepted an insufficient amount.");
    }

    /**
     * Tests the function updatePurchase() within Purchase with a valid input.
     */
    @Test
    public void testUpdatePurchase_Valid()
    {
        ItemDTO item = inventory.fetchItemData("1");

        purchase.updatePurchase(item, 1);
    }

    /**
     * Tests the function updatePurchase() within Purchase with an invalid input.
     */
    @Test
    public void testUpdatePurchase_Invalid()
    {
        purchase.updatePurchase(null, 1);

        String output = printoutBuffer.toString();
        assertTrue(output.contains("The object item can not be null"), "The updatePurchase function accepted a null input.");
    }

}
