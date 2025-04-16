package com.company.FindMe.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponseDto {

    private Long id;
    private String fullName;
    private Integer age;
    private String gender;
    private String lastLocation;
    private LocalDate missingPlace;
    private String status;
}
