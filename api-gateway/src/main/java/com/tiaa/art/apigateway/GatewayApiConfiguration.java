package com.tiaa.art.apigateway;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayApiConfiguration extends RouteBuilder {

    @Override
    public void configure() throws Exception {

    	restConfiguration()
        .component("servlet")
        .host("localhost")
        .port("8080")
        .bindingMode(RestBindingMode.json);
        rest("/api").description("Gateway API")
            .consumes("application/json").produces("application/json")

            .get("/customer").description("Get customer")
                .route().to("direct:getCustomer");

           

        from("direct:getCustomer")
            .to("http://localhost:8081/customer")
            .unmarshal().json(JsonLibrary.Jackson, Customer.class);

    /*   from("direct:getUserById")
           .to("http://localhost:8082/users/${header.id}")
           .unmarshal().json(JsonLibrary.Jackson, User.class); */
    	
    	
    	
    
    }
}
