package org.apache.camel.example.cxf.proxy;
import com.veriqual.integration.webservice.InventoryWS;

public class InventoryWSImplService implements InventoryWS {
	
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
