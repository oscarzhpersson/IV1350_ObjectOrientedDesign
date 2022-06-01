package com.opers.iv1350.integration;

/**
 * Exception to be called when an identifier which does not exist within the catalog is passed.
 */
public class NoSuchItemException extends Exception
{

    private String identifier;
    
    /**
     * Creates a new instance of the exception thrown when an identifier not corresponding to
     * an existing item is passed.
     * @param identifier The identifier which was passed, not corresponding to an item in the catalog.
     */
    public NoSuchItemException (String identifier)
    {
        super(String.format("The queried item identifier, %s, does not correspond to an existing item.", identifier));
        this.identifier = identifier;
    }

    /**
     * Getter function for the identifier which raised the exception.
     * @return The identifier which did not correspond to an item in the catalog.
     */
    public String getNonExistentItemIdentifier()
    {
        return identifier;
    }

}
