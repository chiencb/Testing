package com.aia.aiaedownload.services.case360;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class Case360Configuration {

	@Value("${case360.generated.package}")
    private String generatedPackage;

    @Value("${case360.soap.address.location}")
    private String addressLocation;

	@Value("${case360.username}")
    private String username;

    @Value("${case360.password}")
    private String password;

	@Bean
	public Jaxb2Marshaller marshallerCase360() {
		Jaxb2Marshaller marshallerCase360 = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshallerCase360.setContextPath(generatedPackage);
		return marshallerCase360;
	}

	@Bean
	public Case360 case360(Jaxb2Marshaller marshallerCase360) {
		Case360 client = new Case360();
		WebServiceTemplate template = client.getWebServiceTemplate();
		Case360MessageSenderAuth sender = new Case360MessageSenderAuth();
		sender.setUsername(username);
		sender.setPassword(password);
		template.setMessageSender(sender);
		client.setDefaultUri(addressLocation);
		client.setMarshaller(marshallerCase360);
		client.setUnmarshaller(marshallerCase360);
		return client;
	}

}
