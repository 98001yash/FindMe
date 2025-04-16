package com.company.FindMe.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportRequest {

    private String fullName;
    private Integer age;
    private String gender;
    private String lastSeenLocation;
    private String description;
    private LocalDate missingSince;
    private String contactPhone;
    private String contactEmail;
}
