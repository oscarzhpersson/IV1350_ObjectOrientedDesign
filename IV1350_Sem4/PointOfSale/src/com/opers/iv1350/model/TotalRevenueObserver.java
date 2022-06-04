// Package declarations.
package com.opers.iv1350.model;

/**
 * Observer (interface) interface for the total revenue.
 * To be invoked when the total revenue changes.
 */
public interface TotalRevenueObserver
{
    /**
     * Invoked when the total revenue changes from a purchase.
     * 
     * @param difference The difference in revenue (added or subtracted).
     */
    void totalRevenueUpdate(float difference);
}
