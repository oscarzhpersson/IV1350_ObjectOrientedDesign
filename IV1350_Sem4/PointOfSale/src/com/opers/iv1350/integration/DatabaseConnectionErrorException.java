package com.opers.iv1350.integration;

/**
 * Exception to be called when the system can not connect to a/the database concerning item inventory.
 */
public class DatabaseConnectionErrorException extends RuntimeException
{
    /**
     * Creates a new instance of the exception thrown if the database is out of reach.
     */
    public DatabaseConnectionErrorException ()
    {
        super("A connection could not be established to the database. Please contact your system administrator.");
    }

}
