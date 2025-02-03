package com.uslbd.report.service;

import com.uslbd.report.model.ReportDTO;

public interface ReportHtmlService {
    ReportDTO getReportInHTML(String reportType, String loanId, String string1, String branchName);
}
