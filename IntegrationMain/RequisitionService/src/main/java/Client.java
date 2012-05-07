import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.veriqual.integration.webservice.RequisitionWS;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		URL wsdlURL = new URL("http://localhost:8080/requisition/RequisitionImpl?wsdl");
		QName SERVICE_NAME = new QName("http://webservice.integration.veriqual.com/", "RequisitionImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		RequisitionWS rs = service.getPort(RequisitionWS.class);
		System.out.println("========================================");
		System.out.print(rs.sendRequisition(10));
		System.out.print(rs.sendRequisition(9));
		System.out.println("========================================");
	}

}
