package com.aia.aiaedownload.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EDocumentImageDTO {
    protected String policyNum;
    protected String documentId;
    protected String dgDocName;
    protected String docTypeCode;
    protected String docType;
    protected String dateReceived;
}
