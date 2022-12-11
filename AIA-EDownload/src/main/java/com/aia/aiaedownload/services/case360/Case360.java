package com.aia.aiaedownload.services.case360;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import com.aia.aiaedownload.generated.case360.GetFile;
import com.aia.aiaedownload.generated.case360.GetFileResponse;
import java.math.BigDecimal;

public class Case360 extends WebServiceGatewaySupport {

    @Value("${case360.namespace.uri}")
    private String namespaceUri;

    @Value("${case360.soap.address.location}")
    private String addressLocation;

    public GetFileResponse getFileCase360(BigDecimal docId, int number) {
        try {
            GetFile request = new GetFile();
            request.setBigDecimal1(docId);
            request.setInt2(number);
            JAXBElement<GetFile> jaxbElement = new JAXBElement<GetFile>(
                    new QName(namespaceUri, "getFile"),
                    GetFile.class, request);

            Object response = getWebServiceTemplate().marshalSendAndReceive(
                addressLocation, jaxbElement, null);
            return ((JAXBElement<GetFileResponse>) response).getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
