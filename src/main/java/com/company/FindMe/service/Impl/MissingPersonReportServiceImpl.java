package com.company.FindMe.service.Impl;

import com.company.FindMe.dtos.CreateReportRequest;
import com.company.FindMe.dtos.ReportResponseDto;
import com.company.FindMe.entities.MissingPersonReport;
import com.company.FindMe.enums.ReportStatus;
import com.company.FindMe.exceptions.ResourceNotFoundException;
import com.company.FindMe.repository.MissingPersonReportRepository;
import com.company.FindMe.service.MissingPersonReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MissingPersonReportServiceImpl implements MissingPersonReportService {

    private final MissingPersonReportRepository reportRepository;
    private final ModelMapper modelMapper;

    @Override
    public ReportResponseDto createReport(CreateReportRequest request, Long userId) {
       log.info("Creating report for userId: {}",userId);

        MissingPersonReport report = modelMapper.map(request, MissingPersonReport.class);
        report.setStatus(ReportStatus.PENDING);
        report.setCreatedByUserId(userId);
        report.setCreatedAt(LocalDateTime.now());

        MissingPersonReport savedReport = reportRepository.save(report);
        return modelMapper.map(savedReport, ReportResponseDto.class);
    }

    @Override
    public List<ReportResponseDto> getAllReports() {
       log.info("Fetching all reports");
       return reportRepository.findAll().stream()
               .map(report->modelMapper.map(report, ReportResponseDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getReportByStatus(ReportStatus status) {
     log.info("Fetching report with the status: {}",status);
     return reportRepository.findByStatus(status).stream()
             .map(report->modelMapper.map(report, ReportResponseDto.class))
             .collect(Collectors.toList());
    }

    @Override
    public ReportResponseDto getReportById(Long id) {
       log.info("Fetching report with id: {}",id);
       MissingPersonReport report = reportRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Report not found with id: " + id));
        return modelMapper.map(report, ReportResponseDto.class);
    }

    @Override
    public ReportResponseDto updateReportStatus(Long reportId, ReportStatus status) {
        log.info("Updating status of reportId: {} to {}", reportId, status);
        MissingPersonReport report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with id: " + reportId));
        report.setStatus(status);
        MissingPersonReport updatedReport = reportRepository.save(report);
        return modelMapper.map(updatedReport, ReportResponseDto.class);
    }

    @Override
    public List<ReportResponseDto> getReportByUserId(Long userId) {
        log.info("Fetching reports created by userId: {}", userId);
        return reportRepository.findByCreatedByUserId(userId).stream()
                .map(report -> modelMapper.map(report, ReportResponseDto.class))
                .collect(Collectors.toList());
    }
}
