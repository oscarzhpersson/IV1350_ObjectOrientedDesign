// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import com.opers.iv1350.dto.ItemDTO;

public class InventorySystem
{

    /**
     * Wrapper class for the item, containing the item and its current inventory.
     */
    private class itemIndex
    {
        ItemDTO item;
        int balance;

        public itemIndex (ItemDTO item, int balance)
        {
            this.item = item;
            this.balance = balance;
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
        public int getBalance () { return balance; }
    }
    
    public InventorySystem ()
    {

    }

    /**
     * 
     * Fetches an item from the inventory system with a corresponding ID.
     * 
     * @param id The ID of the item.
     * @return ...
     */
    public ItemDTO fetchItemData (int id)
    {
        return null;
    }

    /**
     * 
     * Updates the inventory state of the internal implementation of the inventory system.
     * 
     * @param id The ID of the item which we want to update the inventory of.
     * @param quantity The quantity of which we may want to REDUCE the item inventory of.
     */
    public void updateInventory (int id, int quantity)
    {

    }
}
