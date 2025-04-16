package com.company.FindMe.controller;


import com.company.FindMe.dtos.CreateReportRequest;
import com.company.FindMe.dtos.ReportResponseDto;
import com.company.FindMe.enums.ReportStatus;
import com.company.FindMe.service.MissingPersonReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
@Slf4j
public class MissingPersonReportController {

    private final MissingPersonReportService reportService;

    // Create a new missing person report
    @PostMapping
    public ResponseEntity<ReportResponseDto> createReport(@RequestBody CreateReportRequest request){
        Long userId = 1L;
        log.info("Received request to create a report by userId: {}",userId);
        ReportResponseDto response = reportService.createReport(request, userId);
        return ResponseEntity.ok(response);
    }

    // retrieve all reports
    @GetMapping
    public ResponseEntity<List<ReportResponseDto>> getAllReports(){
        log.info("Received request to fetch all reports..");
        List<ReportResponseDto> responses = reportService.getAllReports();
        return ResponseEntity.ok(responses);
    }

    // Retrieve reports by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ReportResponseDto>> getReportByStatus(@PathVariable ReportStatus status){
        log.info("Received request to fetch reports with status: {}", status);

        List<ReportResponseDto> responses = reportService.getReportByStatus(status);
        return ResponseEntity.ok(responses);
    }

    // get a specific report By ID
    @GetMapping("/{id}")
    public ResponseEntity<ReportResponseDto> getReportById(@PathVariable Long id){
        log.info("Received request to fetch report with id: {}",id);
        ReportResponseDto response = reportService.getReportById(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ReportResponseDto> updateReportStatus(@PathVariable Long id,  @RequestParam  ReportStatus status){
        log.info("Received request to update status of report Id: {} TO {}",id, status);
        ReportResponseDto response = reportService.updateReportStatus(id, status);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReportResponseDto>> getReportByUserId(@PathVariable Long userId){
        log.info("Received request to fetch reports created by userId: {}",userId);
        List<ReportResponseDto> responses = reportService.getReportByUserId(userId);
        return ResponseEntity.ok(responses);
    }
}
