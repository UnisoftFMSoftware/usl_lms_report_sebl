package com.uslbd.report;

import net.sf.jasperreports.engine.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private static final String REPORT_PATH = "report_format/SEBL_A4.jrxml";
    private static final String OUTPUT_FILE = "report_generated/SEBL_A4_Report.pdf";

    @PostMapping("/generate")
    public ResponseEntity<Resource> generateReport(@RequestBody Map<String, Object> parameters) {
        try {
            // Compile JRXML file
            JasperReport jasperReport = JasperCompileManager.compileReport(REPORT_PATH);

            // Fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Export to PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, OUTPUT_FILE);

            // Load generated PDF
            Path pdfPath = Paths.get(OUTPUT_FILE);
            Resource fileResource = new UrlResource(pdfPath.toUri());

            if (fileResource.exists() || fileResource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + OUTPUT_FILE)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(fileResource);
            } else {
                return ResponseEntity.badRequest().build();
            }

        } catch (JRException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/generate")
    public ResponseEntity<Resource> getReport() {
        try {

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title", "Sample Report Title"); // Set your title here

            // Compile JRXML file
            JasperReport jasperReport = JasperCompileManager.compileReport(REPORT_PATH);

            // Fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Export to PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, OUTPUT_FILE);

            // Load generated PDF
            Path pdfPath = Paths.get(OUTPUT_FILE);
            Resource fileResource = new UrlResource(pdfPath.toUri());

            if (fileResource.exists() || fileResource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + OUTPUT_FILE)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(fileResource);
            } else {
                return ResponseEntity.badRequest().build();
            }

        } catch (JRException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}

