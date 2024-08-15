package com.lazarev.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAdditionRequest {
    private Integer id;
    private String name;
    private String email;

    private String department;
    private Integer departmentId;
}
