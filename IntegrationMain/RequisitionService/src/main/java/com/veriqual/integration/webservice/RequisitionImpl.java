
package com.veriqual.integration.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "com.veriqual.integration.webservice.RequisitionWS")
public class RequisitionImpl implements RequisitionWS {

	@Override
	public boolean sendRequisition(int n) {
		if(n < 10) return true;
		else return false;
	}
}

