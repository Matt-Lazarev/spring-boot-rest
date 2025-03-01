package com.lazarev.rest.mapper;

import com.lazarev.rest.dto.CustomerDto;
import com.lazarev.rest.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto dto);
}
