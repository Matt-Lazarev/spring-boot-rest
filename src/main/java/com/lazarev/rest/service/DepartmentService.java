package com.lazarev.rest.service;

import com.lazarev.rest.dto.EmployeeAdditionRequest;
import com.lazarev.rest.dto.EmployeeAdditionResponse;
import com.lazarev.rest.entity.Department;
import com.lazarev.rest.entity.Employee;
import com.lazarev.rest.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    public EmployeeAdditionResponse addEmployeeToDepartment(EmployeeAdditionRequest request){
        Optional<Department> departmentOptional = getOrDefault(request);
        Optional<Employee> employeeOptional = employeeService.getByIdOrDefault(request);

        if(departmentOptional.isEmpty()){
            return new EmployeeAdditionResponse(false, "Department not found");
        }

        if(employeeOptional.isEmpty()){
            return new EmployeeAdditionResponse(false, "Employee not found");
        }

        Department department = departmentOptional.get();
        Employee employee = employeeOptional.get();
        department.addEmployee(employee);

        departmentRepository.save(department);

        return new EmployeeAdditionResponse(true, "Success");
    }

    private Optional<Department> getOrDefault(EmployeeAdditionRequest request){
        if(request.getDepartmentId() == null){
            Department department = new Department();
            department.setName(request.getDepartmentName());
            return Optional.of(department);
        }

        return departmentRepository.findById(request.getDepartmentId());
    }
}
