package com.aia.aiaedownload.controllers;

import com.aia.aiaedownload.generated.aiafbusinessservices.ResultOutput;
import com.aia.aiaedownload.services.EDownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/edownload")
@Description("APIs for EDownload document")
public class EDownloadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EDownloadController.class);

    @Autowired
    private EDownloadService eDownloadService;

    @PostMapping("getListEDocument")
    public ResponseEntity<List<ResultOutput>> getListEDocument(@RequestParam() String policyNumber) {
        return ResponseEntity.ok(eDownloadService.getListEDocument(policyNumber));
    }

    @PostMapping("getFileEDocument")
    public ResponseEntity<byte[]> getFileEDocument(@RequestParam() BigDecimal docId, @RequestParam() int number) {
        return ResponseEntity.ok(eDownloadService.getFileEDocument(docId, number));
    }
}
