package com.lazarev.rest.service.mapper;

import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartment().getName()
        );
    }

    public Employee toEntity(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        return employee;
    }

    public List<EmployeeDto> toDtoList(List<Employee> employees){
        return employees.stream()
                .map(this::toDto)
                .toList();
    }

    public void update(Employee employee, EmployeeDto employeeDto){
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
    }
}
