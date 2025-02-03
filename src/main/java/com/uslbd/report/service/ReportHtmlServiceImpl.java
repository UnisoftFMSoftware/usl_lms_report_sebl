package com.uslbd.report.service;

import com.uslbd.report.model.ReportDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportHtmlServiceImpl implements ReportHtmlService {

    @Value("${lms.services.module.corporate.api.base-url}")
    private String CORPORATE_BASE_URL;

    @Override
    public ReportDTO getReportInHTML(String reportType, String loanId, String string1, String branchName) {

        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setReportInHtml("<h1>Report Test</h1>");
        reportDTO.setReportInHtml("<h1>Report Test</h1>");


        return reportDTO;
    }
}
