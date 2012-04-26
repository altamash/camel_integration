CXF WebService Proxy
====================

Proxy to a real web service by a Camel application using the camel-cxf component

You will need to compile this example first:
  mvn compile

To run the example type:
  mvn camel:run

The proxied webservice is located at
  http://localhost:9080/stock/InventoryWSImpl

The real webservice is located at
  http://localhost:8080/stock/InventoryWSImpl

The webservice WSDL is exposed at:
  http://localhost:9080/stock/InventoryWSImpl?wsdl

To stop context hit ctrl + c

To make a SOAP call open soapUI or another SOAP query tool
