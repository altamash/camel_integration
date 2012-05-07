package com.veriqual.integration.webservice;

import javax.jws.WebService;

@WebService
public interface RequisitionWS {
	boolean sendRequisition(int n);
}

