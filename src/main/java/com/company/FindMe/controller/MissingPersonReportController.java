package com.company.FindMe.controller;


import com.company.FindMe.dtos.CreateReportRequest;
import com.company.FindMe.dtos.ReportResponseDto;
import com.company.FindMe.service.MissingPersonReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
