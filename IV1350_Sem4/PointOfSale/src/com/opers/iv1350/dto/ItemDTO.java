// Package declarations.
package com.opers.iv1350.dto;


/**
 * DTO for the item object, containing all of its data.
 */
public class ItemDTO
{

    private String id;
    private String itemName;
    private float price;
    private int vat;
    private String description;
    
    /**
     * 
     * Constructor for the ItemDTO object.
     * 
     * @param id The ID of the item.
     * @param itemName The name of the item.
     * @param price The price of the item.
     * @param vat The VAT rate of the item.
     * @param description A short description of the item.
     */
    public ItemDTO (String id, String itemName, float price, int vat, String description)
    {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.vat = vat;
        this.description = description;
    }

    /**
     * Getter function for the item ID.
     * @return The ID of the item.
     */
    public String getId () { return id; }

    /**
     * Getter function for the item name.
     * @return The name of the item.
     */
    public String getItemName () { return itemName; }

    /**
     * Getter function for the item price.
     * @return The price of the item.
     */
    public float getPrice () { return price; }

    /**
     * Getter function for the item VAT.
     * @return The VAT of the item.
     */
    public int getVat () { return vat; }

    /**
     * Getter function for the item description.
     * @return The description of the item.
     */
    public String getDescription () { return description; }

    /**
     *  Override for the toString() function.
     *  Prints the values of the specific object.
     */
    @Override
    public String toString()
    {
        return String.format("Item: %s, Price: %s, VAT rate: %d, Description: %s", itemName, price, vat, description);
    }

}
