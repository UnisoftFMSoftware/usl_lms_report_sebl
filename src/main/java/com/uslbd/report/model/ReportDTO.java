package com.uslbd.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private String reportInHtml;

    public String getReportInHtml() {
        return reportInHtml;
    }

    public void setReportInHtml(String reportInHtml) {
        this.reportInHtml = reportInHtml;
    }

    public String getPdfFilePath() {
        return pdfFilePath;
    }

    public void setPdfFilePath(String pdfFilePath) {
        this.pdfFilePath = pdfFilePath;
    }

    private String pdfFilePath;



}
