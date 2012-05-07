package com.veriqual.integration.service;

public class InventoryServiceImpl implements InventoryService {
	
	private int itemCount;
	private int reorderLevel;

	public void addItem() {
		System.out.println("addItem() in InventoryServiceImpl ========================");
		itemCount++;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setReorderLevel(int i) {
		System.out.println("setReorderLevel() in InventoryServiceImpl ======================== " + i);
		reorderLevel = i;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public boolean reorder() {
		return reorderLevel >= itemCount;
	}

}
