// Package declarations.
package com.opers.iv1350.controller;

// Import declarations.
import org.junit.jupiter.api.*;
import com.opers.iv1350.model.Purchase;

// Static import declarations.
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for the Controller class.
 */
public class ControllerTest
{

    private Controller controller;
    
    /**
     * Sets up a new clean-slate controller before each test.
     */
    @BeforeEach
    public void setUp()
    {
        controller = new Controller();

        controller.startSale();
    }

    /**
     * Tears down loose ends after testing execution.
     */
    @AfterEach
    public void tearDown()
    {
        controller = null;
    }

    /**
     * Runs test for the enterItem() function.
     * Tests with a valid input, an item that exists in the registry.
     */
    @Test
    public void testEnterItemValid()
    {
        controller.enterItem("1", 1);

        assertTrue(controller.getPurchase().getItems().size() > 0, "The enterItem function failed with a valid input. A valid ID was not found.");
    }

    /**
     * Runs test for the enterItem() function.
     * Tests with an item that does not exist in the registry.
     */
    @Test
    public void testEnterItemItemNotExists()
    {
        controller.enterItem("-1", 1);
        int purchaseSize = controller.getPurchase().getItems().size();

        assertFalse(purchaseSize > 0, "An item that does not exist was found and/or added.");
    }

    /**
     * Runs rest for the registerPayment() function.
     * Evaluates to true if nothing else fails. This is only an intermediate call which makes this necessary as exceptions has not been added yet.
     */
    @Test
    public void testRegisterPaymentValid()
    {
        int payment = 50;

        controller.registerPayment(payment);

        boolean paymentIsSufficient = payment > controller.getPurchase().getTotal();

        float change = controller.getPurchase().getChange();

        assertTrue((change > 0) && paymentIsSufficient, "A valid payment for the current purchase failed.");
    }

    /**
     * Runs rest for the registerPayment() function.
     * Evaluates to true if nothing else fails. This is only an intermediate call which makes this necessary as exceptions has not been added yet.
     */
    @Test
    public void testRegisterPaymentInvalid()
    {
        controller.registerPayment(-1);
        
        float change = controller.getPurchase().getChange();

        assertTrue(Float.compare(change, 0) == 0, "An invalid payment passed with an insufficient/invalid amount." + " Input change was: " + change);
    }

    /**
     * Runs test for startSale() function. Checks if objects are initialised correctly.
     */
    @Test
    public void testStartSale()
    {
        assertTrue(controller.getPurchase() != null, "The sale was incorrectly initialised, there is no Purchase object instance.");
    }

}
