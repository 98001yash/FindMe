package com.company.FindMe.repository;

import com.company.FindMe.entities.MissingPersonReport;
import com.company.FindMe.enums.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissingPersonReportRepository extends JpaRepository<MissingPersonReport, Long> {

    List<MissingPersonReport> findByStatus(ReportStatus status);

    List<MissingPersonReport> findByCreatedByUserId(Long userId);

    List<MissingPersonReport> findByLastSeenLocationContainingIgnoreCase(String location);

    List<MissingPersonReport> findByStatusAndLastSeenLocationContainingIgnoreCase(ReportStatus status, String location);
}
