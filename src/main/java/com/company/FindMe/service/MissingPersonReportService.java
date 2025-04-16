package com.company.FindMe.service;

import com.company.FindMe.dtos.CreateReportRequest;
import com.company.FindMe.dtos.ReportResponseDto;
import com.company.FindMe.enums.ReportStatus;

import java.util.List;

public interface MissingPersonReportService {

    ReportResponseDto createReport(CreateReportRequest request, Long userId);

    List<ReportResponseDto> getAllReports();

    List<ReportResponseDto> getReportByStatus(ReportStatus status);

    ReportResponseDto getReportById(Long id);

    ReportResponseDto updateReportStatus(Long reportId, ReportStatus status);

    List<ReportResponseDto> getReportByUserId(Long userId);
}
