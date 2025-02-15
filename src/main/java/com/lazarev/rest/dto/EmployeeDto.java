package com.lazarev.rest.dto;


public record EmployeeDto (
        String name,
        String email,
        DepartmentDto department
) { }
