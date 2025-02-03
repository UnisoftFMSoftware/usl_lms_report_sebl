package com.uslbd.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JasperReportGenerator {
    public static void main(String[] args) {
        try {
            // Define report path
            String jrxmlPath = "report_format/SEBL_A4.jrxml";
            String pdfOutputPath = "report_generated/SEBL_A4_Report.pdf";

            // Compile JRXML to Jasper file
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);

            // Parameters to pass into the report
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title", "Sample Report Title"); // Set your title here

            // Fill the report with data (null means no data source is used)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfOutputPath);

            System.out.println("Report generated successfully: " + new File(pdfOutputPath).getAbsolutePath());
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
