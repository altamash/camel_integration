package com.veriqual.integration.service;

public interface InventoryService 
{
    void addItem();
    int getItemCount();
    void setReorderLevel(int i);
    int getReorderLevel();
    boolean reorder();
}
