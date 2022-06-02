// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import org.junit.jupiter.api.*;
import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.integration.InventorySystem;
import com.opers.iv1350.integration.NoSuchItemException;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the Purchase class.
 */
public class PurchaseTest
{
    private Purchase purchase;
    private InventorySystem inventory;
    
    /**
     * Sets up a new clean-slate controller before each test.
     */
    @BeforeEach
    public void setUp()
    {
        purchase = new Purchase();
        inventory = new InventorySystem();
    }

    /**
     * Tears down loose ends after testing execution.
     */
    @AfterEach
    public void tearDown()
    {
        purchase = null;
        inventory = null;
    }

    /**
     * Tests the function which registers a payent function and calculates change, registerPayment(), using a valid payment.
     */
    @Test
    public void testRegisterPaymentValid()
    {
        try
        {
            ItemDTO item = inventory.fetchItemData("1");
            purchase.updatePurchase(item, 1);

            purchase.registerPayment(Integer.MAX_VALUE);

            assertTrue(purchase.getChange() > 0, "The returned change should be positive, but it is negative.");
        }
        catch(NoSuchItemException exception)
        {
            // TODO: Add the catch clause for the exception.
            exception.printStackTrace();
        }
    }

    /**
     * Tests the function which registers a payment function and calculates change, registerPayment(), using an invalid amount.
     */
    @Test
    public void testRegisterPaymentInvalid()
    {
        try
        {
            ItemDTO item = inventory.fetchItemData("1");

            purchase.updatePurchase(item, 1);
            purchase.registerPayment(-1);

            assertFalse(Math.abs(purchase.getChange()) > purchase.getTotal(), "The registerpayment function accepted an invalid amount.");
        }
        catch(NoSuchItemException exception)
        {
            // TODO: Add the catch clause for the exception.
            exception.printStackTrace();
        }
    }

    /**
     * Tests the function which registers a payment function and calculates change, registerPayment(), using an insufficient amount.
     */
    @Test
    public void testRegisterPaymentInsufficient()
    {
        try
        {
            ItemDTO item = inventory.fetchItemData("1");

            purchase.updatePurchase(item, 1);
            purchase.registerPayment(1);

            assertFalse(purchase.getChange() < 0, "The registerpayment function accepted an insufficient amount.");
        }
        catch(NoSuchItemException exception)
        {
            // TODO: Add the catch clause for the exception.
            exception.printStackTrace();
        }
        
    }

    /**
     * Tests the function updatePurchase() within Purchase with a valid input.
     */
    @Test
    public void testUpdatePurchaseValid()
    {
        try
        {
            ItemDTO item = inventory.fetchItemData("1");
            float itemTotalPrice = item.getPrice() * (1 + item.getVat() * 0.01f);

            purchase.updatePurchase(item, 1);


            assertTrue(itemTotalPrice == purchase.getTotal(), "The total of the purchase does not correspond to the price of the added item");
        }
        catch(NoSuchItemException exception)
        {
            // TODO: Add the catch clause for the exception.
            exception.printStackTrace();
        }
    }

    /**
     * Tests the function updatePurchase() within Purchase with an invalid input.
     */
    @Test
    public void testUpdatePurchaseInvalid()
    {
        purchase.updatePurchase(null, 1);
        assertTrue(purchase.getTotal() == 0, "The updatePurchase function accepted a null input.");
    }

}
