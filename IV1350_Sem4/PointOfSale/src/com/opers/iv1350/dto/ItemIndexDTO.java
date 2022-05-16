package com.opers.iv1350.dto;

/**
* Wrapper class for the item, containing the item and its current inventory.
*/
public class ItemIndexDTO
{
    ItemDTO item;
    int quantity;

    /**
    * Constructor for the wrapper object.
    * 
    * @param item The item which it should contain.
    * @param quantity The quantity of which should be stored.
    */
    public ItemIndexDTO (ItemDTO item, int quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }

    /**
    * Getter function for the item.
    * @return The item in the form of an itemDTO.
    */
    public ItemDTO getItem () { return item; }

    /**
    * Getter function for the item inventory balance.
    * @return The inventory balance of the item.
    */
    public int getQuantity () { return quantity; }

    /**
    * Setter function for the item inventory balance.
    * @param value The new value for the balance of the inventory.
    */
    public void setQuantity (int value) { quantity = value; }
}