package com.lazarev.rest.service;

import com.lazarev.rest.dto.CustomerDto;
import com.lazarev.rest.entity.Customer;
import com.lazarev.rest.exception.NoSuchEntityException;
import com.lazarev.rest.mapper.CustomerMapper;
import com.lazarev.rest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    public CustomerDto getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Customer not found with id: " + id));
        return customerMapper.toDto(customer);
    }

    public void createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer) {
        Customer updatableCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("Customer not found with id: " + id));

        updatableCustomer.setFirstname(customer.getFirstname());
        updatableCustomer.setLastname(customer.getLastname());
        updatableCustomer.setEmail(customer.getEmail());
        updatableCustomer.setPassword(customer.getPassword());

        customerRepository.save(updatableCustomer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}

