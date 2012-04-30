/**
 * Copyright 2011 FuseSource
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.camel.example.cxf.proxy;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.impl.DefaultExchange;
import org.apache.cxf.message.MessageContentsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReorderProcessor implements Processor {
	public static final Logger log = LoggerFactory
			.getLogger(ReorderProcessor.class);
	ProducerTemplate template;

	public void setProducer(ProducerTemplate temp) {
		template = temp;
	}

	public void process(Exchange exchng) throws Exception {
		Object a = exchng
				.getIn()
				.getHeader(
						org.apache.camel.component.cxf.common.message.CxfConstants.OPERATION_NAME);

		// Object[] args = exchng.getIn().getBody(Object[].class);
		MessageContentsList msgList = (MessageContentsList) exchng.getIn().getBody();
		log.info(a + " returned " + msgList.get(0));

		if (msgList.get(0) == Boolean.TRUE) {
			String req = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.integration.veriqual.com/\">"
					+ "<soapenv:Header/><soapenv:Body><web:sendRequisition><arg0>9</arg0></web:sendRequisition></soapenv:Body></soapenv:Envelope>";
			template.requestBody(
					"http://localhost:9080/requisition/RequisitionImpl", req,
					Boolean.class);
		}
	}

}
