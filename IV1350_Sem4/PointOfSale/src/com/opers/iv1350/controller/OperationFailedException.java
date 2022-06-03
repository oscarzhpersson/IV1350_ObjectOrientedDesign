// Import declarations.
package com.opers.iv1350.controller;

/**
 * Thrown during a failed operation.
 */
public class OperationFailedException extends Exception
{

    /**
     * Creates a new instance of an OperationFailedException. Takes a specified message and cause.
     * @param msg The exception message.
     * @param cause The cause of the exception.
     */
    public OperationFailedException(String msg, Exception cause)
    {
        super(msg, cause);
    }
}
