# Questions for the help session:

    What should I do when nothing is to be returned in a function which has thrown an exception?

## Packages:

   


# Notes:

    
# TODO:

 - Maybe fix Task 1 a). Possibly create an aux function which calls enterItem but is of type void. Or change return to string and return the string only.
 - Write catch() blocks for the tests for the exceptions.

## Task 1:
    - Exceptions for alternative flow 3-4a
    - Exceptions for database connection


# Notes during progress:

    Exception --> Checked --> Business logic
    RuntimeException --> UnChecked --> Bug

   NoSuchItemException handles business logic (entered item not found). Thus it is a checked exception and should be a Exception (Not runtime).