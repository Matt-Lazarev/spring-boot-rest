package com.lazarev.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAdditionRequest {
    //employee
    private Integer employeeId;
    private String name;
    private String email;
    //department
    private Integer departmentId;
    private String departmentName;
}
