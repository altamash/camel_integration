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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetReOrderLevelProcessor implements Processor {
    public static final Logger log = LoggerFactory.getLogger(GetReOrderLevelProcessor.class);

    public void process(Exchange exchng) throws Exception {
        Object[] args =  exchng.getIn().getBody(Object[].class);
        
        int level = (Integer)args[0];

//        String id = (String) args[0];
//        Holder<String> status = (Holder<String>) args[1];
//        Holder<String> statusMsg = (Holder<String>) args[2];
//
//        log.debug("Getting status for customer '" + id + "'");
//
//        // This is where you'd actually do the work! Setting
//        // the holder values to constants for the sake of brevity.
//        //
//        status.value = "Offline";
//        statusMsg.value = "Going to sleep now!";
//        
//        exchng.getOut().setBody(new Object[] {status , statusMsg});
        
//        Holder<Integer> level = (Holder<Integer>) args[0];

        log.debug("Getting reorder level '" + args.length);
        System.out.println("Getting reorder level");        

        exchng.getOut().setBody(new Object[]{new Integer(level)});
    }

}
