package org.apache.camel.example.cxf.proxy;

import javax.jws.WebService;

@WebService
public interface InventoryWS {
	void addItem();
    int getItemCount();
    void setReorderLevel(int i);
    int getReorderLevel();
    boolean reorder();
}

