package com.demo.springboot.rest.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
       Server server = new Server();
       server.setUrl("http://localhost:8080/app");
       server.setDescription("Checking");

       Contact myContact = new Contact();
       myContact.setName("Umesh Meka");
       myContact.setEmail("umeshmeka@gmail.com");

       Info information = new Info()
               .title("Student Management System API")	
               .version("1.0")
               .description("This API exposes endpoints to manage students.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(server));
   }
}
