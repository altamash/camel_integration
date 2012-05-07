
package com.veriqual.integration.webservice;

import javax.jws.WebService;
import com.veriqual.integration.service.InventoryService;

@WebService(endpointInterface = "com.veriqual.integration.webservice.InventoryWS")
public class InventoryWSImpl implements InventoryWS {
	
	private InventoryService inventoryService;

	@Override
	public void addItem() {
		getInventoryService().addItem();
	}

	@Override
	public int getItemCount() {
		return getInventoryService().getItemCount();
	}

	@Override
	public void setReorderLevel(int i) {
		System.out.println("setReorderLevel() in InventoryWSImpl ======================== " + i);
		getInventoryService().setReorderLevel(i);		
	}

	@Override
	public int getReorderLevel() {
		return getInventoryService().getReorderLevel();
	}

	@Override
	public boolean reorder() {
		return getInventoryService().reorder();
	}
	
	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		System.out.println("InventoryService = " + inventoryService);
		this.inventoryService = inventoryService;
	}
}

