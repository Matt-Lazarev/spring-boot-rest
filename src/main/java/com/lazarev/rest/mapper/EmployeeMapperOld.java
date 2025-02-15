//package com.lazarev.rest.mapper;
//
//import com.lazarev.rest.dto.DepartmentDto;
//import com.lazarev.rest.dto.EmployeeDto;
//import com.lazarev.rest.entity.Department;
//import com.lazarev.rest.entity.Employee;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmployeeMapperOld {
//
//    public EmployeeDto toDto(Employee employee) {
//        EmployeeDto dto = new EmployeeDto();
//        dto.setName(employee.getName());
//        dto.setEmail(employee.getEmail());
//
//        DepartmentDto departmentDto = new DepartmentDto();
//        departmentDto.setName(employee.getDepartment().getName());
//        dto.setDepartment(departmentDto);
//        return dto;
//    }
//
//    public Employee toEntity(EmployeeDto employeeDto) {
//        Employee employee = new Employee();
//        employee.setName(employeeDto.getName());
//        employee.setEmail(employeeDto.getEmail());
//
//        Department department = new Department();
//        department.setName(employee.getDepartment().getName());
//
//        employee.setDepartment(department);
//
//        return employee;
//    }
//
//    public void update(Employee employee, EmployeeDto dto) {
//        employee.setName(dto.getName());
//        employee.setEmail(dto.getEmail());
//
//        Department department = new Department();
////        department.setName(dto.getDepartment());
//        employee.setDepartment(department);
//    }
//}
