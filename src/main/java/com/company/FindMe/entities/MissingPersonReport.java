package com.company.FindMe.entities;


import com.company.FindMe.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "missing_person_report")
public class MissingPersonReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Integer age;
    private String gender;
    private String lastLocation;
    private String description;
    private LocalDate missingSince;


    @Enumerated(EnumType.STRING)
    private ReportStatus status;
    private String contactPhone;
    private String contactEmail;
    private Long createdByUserId;
    private LocalDateTime createdAt;
}
