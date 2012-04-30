package org.apache.camel.example.cxf.proxy;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A Main to let you easily start the application from a IDE. Usually you can
 * just right click and choose Run
 * @version
 */
public final class MyMain {

private MyMain() {
		// to comply with check style
	}

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context;

		context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/camel-config.xml"});
		context.start();

		CamelContext camel = (CamelContext) context.getBean("camelContext");
		RouteBuilder builder = new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("cxf:bean:proxyWebService").to("cxf:bean:webService")
					.choice()
						.when(header(CxfConstants.OPERATION_NAME).isEqualTo("getReorderLevel"))
							.log("starting processor GetReOrderLevelProcessor")
							.to("getReorderLevel") // Processor bean
						.when(header(CxfConstants.OPERATION_NAME).isEqualTo("getItemCount"))
							.log("starting processor GetItemCountProcessor")
							.to("getItemCount") // Processor bean
						.when(header(CxfConstants.OPERATION_NAME).isEqualTo("reorder"))
							.log("starting processor ReorderProcessor")
							.to("reorder"); // Processor bean, may route to route2
				from("cxf:bean:proxyWebReqService").to("cxf:bean:webReqService")
					.choice()
						.when(header(CxfConstants.OPERATION_NAME).isEqualTo("sendRequisition"))
							.log("starting processor SendRequisitionProcessor")
							.to("sendRequisition"); // Processor bean
			}
		};

		camel.addRoutes(builder);
		camel.start();

	}
}
