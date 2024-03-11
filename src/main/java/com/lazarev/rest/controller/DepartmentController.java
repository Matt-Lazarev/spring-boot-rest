package com.lazarev.rest.controller;

import com.lazarev.rest.dto.EmployeeAdditionRequest;
import com.lazarev.rest.dto.EmployeeAdditionResponse;
import com.lazarev.rest.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/add-employee")
    public EmployeeAdditionResponse addEmployeeToDepartment(@RequestBody EmployeeAdditionRequest employeeAdditionRequest){
        return departmentService.addEmployeeToDepartment(employeeAdditionRequest);
    }
}
