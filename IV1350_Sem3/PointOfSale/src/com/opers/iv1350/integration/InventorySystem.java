// Package declarations.
package com.opers.iv1350.integration;

// Import declarations.
import com.opers.iv1350.dto.ItemDTO;

import java.util.ArrayList;

/**
 * Representation of external inventory system access point.
 */
public class InventorySystem
{

    private ArrayList<itemIndex> inventory = new ArrayList<itemIndex>();

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

        /**
         * Setter function for the item inventory balance.
         * @param value The new value for the balance of the inventory.
         */
        public void setBalance (int value) { balance = value; }
    }
    
    /**
     * Constructor for the InventorySystem object class.
     */
    public InventorySystem ()
    {

        ItemDTO item = new ItemDTO("1", "Prolog", 20.0f, 5, "The best programming language in the world");
        inventory.add(new itemIndex(item, 1));

    }

    /**
     * 
     * Fetches an item from the inventory system with a corresponding ID.
     * 
     * @param id The ID of the item.
     * @return The itemDTO of the corresponding item.
     */
    public ItemDTO fetchItemData (String id)
    {
        int index = getItemIndex(id);
        return index == -1 ? null : inventory.get(index).getItem();
    }

    /**
     * 
     * Updates the inventory state of the internal implementation of the inventory system.
     * 
     * @param id The ID of the item which we want to update the inventory of.
     * @param quantity The quantity of which we may want to REDUCE the item inventory of.
     */
    public void updateInventory (String id, int quantity)
    {
        int index = getItemIndex(id);

        if (index == -1) return;

        // TODO: Add error handling for when balance is below 0 or is 0. Within first part of ternary.
        inventory.get(index).setBalance( ( inventory.get(index).getBalance() - quantity < 0 ? 0 : inventory.get(index).getBalance() - quantity ) );
    }

    /**
     * Fetches the item index of a specified item ID in inventory list.
     * @param id The ID of the item.
     * @return The index of the item in inventory list.
     */
    private int getItemIndex (String id)
    {
        for (itemIndex i : inventory)
            if (i.item.getId() == id) return inventory.indexOf(i);

        return -1;
    }

}
