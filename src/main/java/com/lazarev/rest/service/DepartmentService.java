package com.lazarev.rest.service;

import com.lazarev.rest.dto.EmployeeAdditionRequest;
import com.lazarev.rest.entity.Department;
import com.lazarev.rest.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found"));
    }

    public Department createDepartment(EmployeeAdditionRequest employeeAdditionRequest) {
        Department department = new Department();
        department.setName(employeeAdditionRequest.getDepartment());
        return department;
    }
}
