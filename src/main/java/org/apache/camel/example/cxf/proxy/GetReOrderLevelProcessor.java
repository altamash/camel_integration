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


public class GetReOrderLevelProcessor implements Processor {
    public static final Logger log = LoggerFactory.getLogger(GetReOrderLevelProcessor.class);

    public void process(Exchange exchng) throws Exception {
    	Object a = exchng.getIn().getHeader(org.apache.camel.component.cxf.common.message.CxfConstants.OPERATION_NAME); 
    	
        Object[] args =  exchng.getIn().getBody(Object[].class);
//
////        int level = (Integer)args[0];
//
//        String id = (String) args[0];
//        Holder<String> status = (Holder<String>) args[1];
//        Holder<String> statusMsg = (Holder<String>) args[2];
////
////        log.debug("Getting status for customer '" + id + "'");
//
//        // This is where you'd actually do the work! Setting
//        // the holder values to constants for the sake of brevity.
//        //
//        status.value = "Offline";
//        statusMsg.value = "Going to sleep now!";
//        
//        exchng.getOut().setBody(new Object[] {status , statusMsg});
//        
//        Holder<Integer> level = (Holder<Integer>) args[0];
//
//        log.debug("Getting reorder level '" + args.length);
//        System.out.println("Getting reorder level");        
//
////        exchng.getOut().setBody(new Object[]{new Integer(level)});
//        
//        log.info("processing exchange in camel");
//
//        BindingOperationInfo boi = (BindingOperationInfo)exchng.getProperty(BindingOperationInfo.class.toString());
//        if (boi != null) {
//            log.info("boi.isUnwrapped" + boi.isUnwrapped());
//        }
//        // Get the parameters list which element is the holder.
//        MessageContentsList msgList = (MessageContentsList)exchng.getIn().getBody();
//        Holder<String> personId = (Holder<String>)msgList.get(0);
//        Holder<String> ssn = (Holder<String>)msgList.get(1);
//        Holder<String> name = (Holder<String>)msgList.get(2);
//
//        if (personId.value == null || personId.value.length() == 0) {
//            log.info("person id 123, so throwing exception");
//            // Try to throw out the soap fault message
////            org.apache.camel.wsdl_first.types.UnknownPersonFault personFault =
////                new org.apache.camel.wsdl_first.types.UnknownPersonFault();
////            personFault.setPersonId("");
////            org.apache.camel.wsdl_first.UnknownPersonFault fault =
////                new org.apache.camel.wsdl_first.UnknownPersonFault("Get the null value of person name", personFault);
////            // Since camel has its own exception handler framework, we can't throw the exception to trigger it
////            // We just set the fault message in the exchange for camel-cxf component handling
////            exchng.getFault().setBody(fault);
//        }
//
//        name.value = "Bonjour";
//        ssn.value = "123";
//        log.info("setting Bonjour as the response");
//        // Set the response message, first element is the return value of the operation,
//        // the others are the holders of method parameters
//        exchng.getOut().setBody(new Object[] {null, personId, ssn, name});
    }

}
