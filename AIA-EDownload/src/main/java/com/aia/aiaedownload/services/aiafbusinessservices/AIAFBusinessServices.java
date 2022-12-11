package com.aia.aiaedownload.services.aiafbusinessservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import com.aia.aiaedownload.generated.aiafbusinessservices.GetListImageCase360;
import com.aia.aiaedownload.generated.aiafbusinessservices.GetListImageCase360Input;
import com.aia.aiaedownload.generated.aiafbusinessservices.GetListImageCase360Response;

public class AIAFBusinessServices extends WebServiceGatewaySupport {

    @Value("${aiafbusiness.namespace.uri}")
    private String namespaceUri;

    @Value("${aiafbusiness.soap.address.location}")
    private String addressLocation;
    
    public GetListImageCase360Response getListImageCase360(String policyNum) {
        try {
            GetListImageCase360 request = new GetListImageCase360();
            GetListImageCase360Input input = new GetListImageCase360Input();
            input.setPolicyNum(policyNum);
            request.setGetListImageCase360Input(input);
            JAXBElement<GetListImageCase360> jaxbElement = new JAXBElement<GetListImageCase360>(
                    new QName(namespaceUri, "getListImageCase360"),
                    GetListImageCase360.class, request);

            Object response = getWebServiceTemplate().marshalSendAndReceive(
                addressLocation, jaxbElement, null);
            return ((JAXBElement<GetListImageCase360Response>) response).getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
