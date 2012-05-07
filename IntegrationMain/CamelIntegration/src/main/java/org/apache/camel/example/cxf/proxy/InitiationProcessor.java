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

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InitiationProcessor implements Processor {
    public static final Logger log = LoggerFactory.getLogger(InitiationProcessor.class);

    public void process(Exchange exchng) throws Exception {
 
//      AbstractApplicationContext context;
//      context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/camel-config.xml"});
//      Exchange senderExchange = new DefaultExchange((CamelContext) context.getBean("camelContext"), ExchangePattern.InOut);
      final List<Integer> params = new ArrayList<Integer>();
      // Prepare the request message for the camel-cxf procedure
      params.add(10);
      exchng.getIn().setBody(params);
      exchng.getIn().setHeader(CxfConstants.OPERATION_NAME, "sendRequisitionResponse");
      exchng.getIn().setHeader(CxfConstants.OPERATION_NAMESPACE, "http://webservice.integration.veriqual.com/");

      
    }

}
