package com.fitnessapp.controller;


import com.fitnessapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/weekly")
    public String viewWeeklyReport(Model model) {
        String report = reportService.generateWeeklyReport();
        model.addAttribute("report", report);
        return "reports/weeklyReport";
    }

    @GetMapping("/monthly")
    public String viewMonthlyReport(Model model) {
        String report = reportService.generateMonthlyReport();
        model.addAttribute("report", report);
        return "reports/monthlyReport";
    }
}

