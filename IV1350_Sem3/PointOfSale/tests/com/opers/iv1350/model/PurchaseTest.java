// Package declarations.
package com.opers.iv1350.model;

// Import declarations.
import org.junit.jupiter.api.*;
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
        ItemDTO item = inventory.fetchItemData("1");
        purchase.updatePurchase(item, 1);

        purchase.registerPayment(Integer.MAX_VALUE);

        assertTrue(purchase.getChange() > 0, "The returned change should be positive, but it is negative.");
    }

    /**
     * Tests the function which registers a payment function and calculates change, registerPayment(), using an invalid amount.
     */
    @Test
    public void testRegisterPaymentInvalid()
    {
        ItemDTO item = inventory.fetchItemData("1");

        purchase.updatePurchase(item, 1);
        purchase.registerPayment(-1);

        assertFalse(Math.abs(purchase.getChange()) > purchase.getTotal(), "The registerpayment function accepted an invalid amount.");
    }

    /**
     * Tests the function which registers a payment function and calculates change, registerPayment(), using an insufficient amount.
     */
    @Test
    public void testRegisterPaymentInsufficient()
    {
        ItemDTO item = inventory.fetchItemData("1");

        purchase.updatePurchase(item, 1);
        purchase.registerPayment(1);

        assertFalse(purchase.getChange() < 0, "The registerpayment function accepted an insufficient amount.");
    }

    /**
     * Tests the function updatePurchase() within Purchase with a valid input.
     */
    @Test
    public void testUpdatePurchaseValid()
    {
        ItemDTO item = inventory.fetchItemData("1");
        float itemTotalPrice = item.getPrice() * (1 + item.getVat() * 0.01f);

        purchase.updatePurchase(item, 1);


        assertTrue(itemTotalPrice == purchase.getTotal(), "The total of the purchase does not correspond to the price of the added item");
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
