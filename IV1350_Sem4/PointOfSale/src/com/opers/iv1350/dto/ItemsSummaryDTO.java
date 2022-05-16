package com.opers.iv1350.dto;

import java.util.ArrayList;

import com.opers.iv1350.dto.ItemDTO;
import com.opers.iv1350.model.Purchase;

/**
 * Class summarising the current state of items within a purchase.
 * To be used when a new item is included or when you want to present the current purchase.
 */
public class ItemsSummaryDTO
{

    ArrayList<ItemDTO> items;
    int quantity;
    Purchase purchase;

    /**
     * Constructor for the ItemsSummaryDTO object.
     * 
     * @param items The items which is to be stored within the DTO. Type, ItemDTO.
     * @param quantity The quantity of the item which were available/to be added.
     * @param purchase The purchase in its current state.
     */
    public ItemsSummaryDTO(ArrayList<ItemDTO> items, int quantity, Purchase purchase)
    {
        this.items = items;
        this.quantity = quantity;
        this.purchase = purchase;
    }

    /**
     *  Override for the toString() function.
     *  Prints the values of the specific object.
     */
    @Override
    public String toString()
    {
        String output = "";

        // Feedback to the view.
        for (int i = 0; i < quantity; i++)
            output += this.items.get(i).toString() + '\n';

        output += purchase.toString();

        return output;
    }

}
