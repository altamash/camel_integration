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

import javax.xml.ws.Holder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetItemCountProcessor implements Processor {
    public static final Logger log = LoggerFactory.getLogger(GetItemCountProcessor.class);

    public void process(Exchange exchng) throws Exception {
    	Object a = exchng.getIn().getHeader(org.apache.camel.component.cxf.common.message.CxfConstants.OPERATION_NAME); 
    	
//      Object[] args =  exchng.getIn().getBody(Object[].class);
      MessageContentsList msgList = (MessageContentsList)exchng.getIn().getBody();
      log.info(a + " returned " + msgList.get(0));
    }

}
