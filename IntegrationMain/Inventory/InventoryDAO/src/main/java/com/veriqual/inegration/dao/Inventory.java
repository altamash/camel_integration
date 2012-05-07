package com.veriqual.inegration.dao;

public class Inventory 
{
    public int getItem_count() {
		return item_count;
	}
	public boolean setItem_count(int item_count) {
		this.item_count = item_count;
		return reorder_level >= item_count; 
	}
	public int getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}
	int item_count;
    int reorder_level;
}
