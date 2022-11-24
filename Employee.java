package com.example.soap;

import com.example.soap.bottomup.generated.GetEmployee;
import com.example.soap.bottomup.generated.GetEmployeeResponse;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;

public class Employee extends WebServiceGatewaySupport {


    public GetEmployeeResponse getEmployee(int employee) {
        GetEmployee request = new GetEmployee();
        request.setArg0(employee);
        JAXBElement<GetEmployee> jaxbElement =
                new JAXBElement<GetEmployee>( new QName("http://server.bottomup.soap.example.com/", "getEmployee"),
                        GetEmployee.class, request);

        Object response = getWebServiceTemplate().marshalSendAndReceive("http://localhost:9091/employeeservicebottomup", jaxbElement, null);
        try {
            StringWriter stringWriter = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(GetEmployeeResponse.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // format the XML output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    true);
            jaxbMarshaller.marshal((JAXBElement<GetEmployeeResponse>)response, stringWriter);
            System.out.println(stringWriter.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        GetEmployeeResponse response = (GetEmployeeResponse) response;

        return null;
    }

}
