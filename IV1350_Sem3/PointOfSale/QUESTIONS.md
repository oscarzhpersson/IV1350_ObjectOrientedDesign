# Questions for the help session:

## Packages:

    Do I have to name the packages 'se.kth...' or may I use my own organisational name 'com.opers...'? Det är OK.

    Should I make model public within view, or should I re-route this? Ska inte vara där.

    What is the opinion of public variables within classes? Should they be avoided? Do I need to re-do everything.

    Är import all okej? " .* ". De ska helst bort egentligen.

    ______________________________________________________________________________________________________

    Is my wrapper for the item in InventorySystem alright?

    In InventorySystem, what should updateInventory do if it has an insufficient balance?

    How does VAT work? Add answer to Purchase.java toString override.

    Do I need to write a wrapper function for the purchase which keeps a balance for the items added instead of just adding them individually? If so, maybe break the existing class out instead.


# Notes:

    Tests can be functionality based. Expected edge cases should be included.

    Inga try-catch och exceptions än. 

    Model ska inte vara sin egen klass. Det ska vara ett paket, inte sin egen klass. Vyn ska aldrig direkt anropa modellen. De ska alltid gå genom controller.

    Man får gå ifrån diagrammet i viss mån när det är rimligt.

    Had to add quantity to updatePurchase() in Purchase.

    I will omit the Payment object as it does not actually do anything.



# Notes during progress:

    Removed model class from program.
    Removed view reference within controller.

    registerPayment was changed to void and to register the amount instead, as it makes more sense.