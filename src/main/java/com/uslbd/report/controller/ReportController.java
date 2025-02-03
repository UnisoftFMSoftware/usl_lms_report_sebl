package com.uslbd.report.controller;
import com.uslbd.report.model.ReportDTO;
import com.uslbd.report.service.ReportHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gateway/html/report")
public class ReportController {

    @Autowired
    ReportHtmlService reportHtmlService;
    @GetMapping(value = "/create_html_pdf")
    public String createHtmlPdf(Model model,
                                @RequestParam(value = "branchName") String branchName,
                                @RequestParam(value = "reportType") String reportType,
                                @RequestParam(value = "loanId") int loanId) throws Exception {

        // Add attributes to the model
        model.addAttribute("loanId", loanId);
        model.addAttribute("reportType", reportType);
        model.addAttribute("branchName", branchName);
        model.addAttribute("mainAccountName", "");
//        model.addAttribute("mainAccountName", corporateLoanService.getGenInfo(loanId).getMainAccountName());

        // Fetch the HTML report data
//      ReportDTO reportDTO = reportHtmlService.getReportInHTML(reportType, Integer.toString(loanId), Integer.toString(loanId), branchName);
        ReportDTO reportDTO = reportHtmlService.getReportInHTML(reportType, Integer.toString(loanId), Integer.toString(loanId), branchName);
        model.addAttribute("reportInHtml", reportDTO.getReportInHtml());
        model.addAttribute("pdfFilePath", reportDTO.getPdfFilePath());

        return "create_html_pdf";  // This refers to the Thymeleaf template
    }
}
