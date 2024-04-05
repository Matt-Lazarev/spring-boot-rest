package com.lazarev.rest.service.mapper;

import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapstructEmployeeMapper {

    @Mapping(target = "department", ignore = true)
    Employee toEntity(EmployeeDto dto);

    @Mapping(target = "department", ignore = true)
    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDtoList(List<Employee> employees);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "department", ignore = true)
    void update(@MappingTarget Employee entity, EmployeeDto dto);
}
