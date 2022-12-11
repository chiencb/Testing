package com.aia.aiaedownload.services.impl;

import com.aia.aiaedownload.generated.aiafbusinessservices.GetListImageCase360Response;
import com.aia.aiaedownload.generated.aiafbusinessservices.ResultOutput;
import com.aia.aiaedownload.generated.case360.GetFileResponse;
import com.aia.aiaedownload.services.EDownloadService;
import com.aia.aiaedownload.services.aiafbusinessservices.AIAFBusinessServices;
import com.aia.aiaedownload.services.case360.Case360;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class EDownloadServiceImpl implements EDownloadService {
    @Autowired
    AIAFBusinessServices aiafBusinessServices;

    @Autowired
    Case360 case360;
    
    @Override
    public List<ResultOutput> getListEDocument(String policyNumber) {
        System.out.println("Get list eDocument with policy number: " + policyNumber);
        try {
            GetListImageCase360Response response = aiafBusinessServices.getListImageCase360(policyNumber);
            return response.getGetListImageCase360Output().getResultOutput();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("EdownloadApplication.main() e: " + e.getMessage());
        }
        return null;
    }

    @Override
    public byte[] getFileEDocument(BigDecimal docId, int number) {
        System.out.println("Get file eDocument with docId: " + docId.toString());
        try {
           GetFileResponse response = case360.getFileCase360(docId, number);
           return response.getResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("getFileEDocument e: " + e.getMessage());
        }
        return null;
    }
}
