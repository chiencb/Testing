package com.aia.aiaedownload.services;

import com.aia.aiaedownload.dto.EDocumentImageDTO;

import java.math.BigDecimal;
import java.util.List;

public interface EDownloadService {

    List<EDocumentImageDTO> getListEDocument(String policyNumber);
    byte[] getFileEDocument(BigDecimal docId, int number);
}
