/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.cxf.proxy;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.spring.Main;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A Main to let you easily start the application from a IDE. Usually you can
 * just right click and choose Run
 * 
 * @version
 */
public final class MyMain {

	private MyMain() {
		// to comply with check style
	}

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context;

		context = new ClassPathXmlApplicationContext(
				new String[] { "META-INF/spring/camel-config.xml" });
		context.start();

		CamelContext camel = (CamelContext) context.getBean("camelContext");
		RouteBuilder builder = new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("cxf:bean:proxyWebService").to("cxf:bean:webService")
					.choice()
						.when(header(CxfConstants.OPERATION_NAME).isEqualTo("getReorderLevel"))
							.log("starting processor GetReOrderLevelProcessor")
							.to("getReorderLevel")
						.when(header(CxfConstants.OPERATION_NAME).isEqualTo("getItemCount"))
							.log("starting processor GetItemCountProcessor")
							.to("getItemCount");
			}
		};

		camel.addRoutes(builder);
		camel.start();

	}
}
