package com.lazarev.rest.mapper;

import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(Employee employee);

    void update(@MappingTarget Employee employee, EmployeeDto dto);
}
