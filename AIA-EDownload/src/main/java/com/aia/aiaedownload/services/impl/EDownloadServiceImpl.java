package com.aia.aiaedownload.services.impl;

import com.aia.aiaedownload.dto.EDocumentImageDTO;
import com.aia.aiaedownload.services.EDownloadService;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EDownloadServiceImpl implements EDownloadService {
    @Override
    public List<EDocumentImageDTO> getListEDocument(String policyNumber) {
        System.out.println("Get list eDocument with policy number: " + policyNumber);
        List<EDocumentImageDTO> listDoc = new ArrayList<>();
        EDocumentImageDTO data1 = new EDocumentImageDTO();
        data1.setDateReceived("2019-10-03");
        data1.setDocumentId("477576");
        data1.setDgDocName("10513371_0104.pdf");
        data1.setDocTypeCode("0104");
        data1.setPolicyNum("22563831");
        data1.setDocType("Copy Polis");
        listDoc.add(data1);
        EDocumentImageDTO data2 = new EDocumentImageDTO();
        data2.setDateReceived("2019-10-03");
        data2.setDocumentId("477585");
        data2.setDgDocName("10069797_0105.pdf");
        data2.setDocTypeCode("0105");
        data2.setPolicyNum("22563831");
        data2.setDocType("Welcome Letter");
        listDoc.add(data2);
        EDocumentImageDTO data3 = new EDocumentImageDTO();
        data3.setDateReceived("2017-11-13");
        data3.setDocumentId("481064");
        data3.setDgDocName("20167401_0106.pdf");
        data3.setDocTypeCode("0106");
        data3.setPolicyNum("22563831");
        data3.setDocType("Transaction Statement");
        listDoc.add(data3);
        return listDoc;
    }

    @Override
    public byte[] getFileEDocument(BigDecimal docId, int number) {

        byte[] fileContent = null;
        try {
            Resource resource = new ClassPathResource("classpath:aia-eDocument.pdf");
            InputStream inputStream = resource.getInputStream();
            fileContent = FileCopyUtils.copyToByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
