import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.veriqual.integration.webservice.InventoryWS;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		URL wsdlURL = new URL("http://localhost:8080/stock/InventoryWSImpl?wsdl");
		QName SERVICE_NAME = new QName("http://webservice.integration.veriqual.com/", "InventoryWSImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		InventoryWS is = service.getPort(InventoryWS.class);
		System.out.println("========================================");
		is.addItem();
		System.out.println("ItemCount: " + is.getItemCount());
		System.out.println("ReorderLevel: " + is.getReorderLevel());
		is.setReorderLevel(4);
		is.addItem();
		System.out.println("ItemCount: " + is.getItemCount());
		System.out.println("ReorderLevel: " + is.getReorderLevel());
		is.addItem();
		is.addItem();
		is.addItem();
		is.addItem();
		is.addItem();
		is.addItem();
		System.out.println("ItemCount: " + is.getItemCount());
		System.out.println("ReorderLevel: " + is.getReorderLevel());
		System.out.println("Reorder: " + is.reorder());
		System.out.println("========================================");
	}

}
