package com.aia.aiaedownload.services.aiafbusinessservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class AIAFBusinessServicesConfiguration {
	
	@Value("${aiafbusiness.generated.package}")
    private String generatedPackage;

    @Value("${aiafbusiness.soap.address.location}")
    private String addressLocation;

	@Value("${aiafbusiness.username}")
    private String username;

    @Value("${aiafbusiness.password}")
    private String password;

	@Bean
	public Jaxb2Marshaller marshallerAIAFBusiness() {
		Jaxb2Marshaller marshallerAIAFBusiness = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshallerAIAFBusiness.setContextPath(generatedPackage);
		return marshallerAIAFBusiness;
	}

	@Bean
	public AIAFBusinessServices aiaFBusiness(Jaxb2Marshaller marshallerAIAFBusiness) {
		AIAFBusinessServices client = new AIAFBusinessServices();
		WebServiceTemplate template = client.getWebServiceTemplate();
		AIAFBusinessServicesMessageSenderAuth sender = new AIAFBusinessServicesMessageSenderAuth();
		sender.setUsername(username);
		sender.setPassword(password);
		template.setMessageSender(sender);
		client.setDefaultUri(addressLocation);
		client.setMarshaller(marshallerAIAFBusiness);
		client.setUnmarshaller(marshallerAIAFBusiness);
		return client;
	}

}
