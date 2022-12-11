package com.aia.aiaedownload.services;

import com.aia.aiaedownload.generated.aiafbusinessservices.ResultOutput;
import java.math.BigDecimal;
import java.util.List;

public interface EDownloadService {

    List<ResultOutput> getListEDocument(String policyNumber);
    byte[] getFileEDocument(BigDecimal docId, int number);
}
