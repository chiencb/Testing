package com.example.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class EmployeeConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.soap.bottomup.generated");
		return marshaller;
	}

	@Bean
	public Employee employee(Jaxb2Marshaller marshaller) {
		Employee client = new Employee();
		WebServiceTemplate template = client.getWebServiceTemplate();
		template.setMessageSender(new WebServiceMessageSenderWithAuth());
		client.setDefaultUri("http://localhost:9091/employeeservicebottomup");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
