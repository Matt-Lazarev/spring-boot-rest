package com.lazarev.rest.service;

import com.lazarev.rest.entity.Employee;
import com.lazarev.rest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAllEmployees();
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with id='%d' not found".formatted(id)));
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(Integer id, Employee employee){
        Employee updatableEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with id=%d not found".formatted(id)));

        updatableEmployee.setName(employee.getName());
        updatableEmployee.setPhone(employee.getPhone());
        updatableEmployee.setEmail(employee.getEmail());

        employeeRepository.save(updatableEmployee);
    }

    @Transactional
    public void deleteEmployeeById(Integer id){
        if(!employeeRepository.existsById(id)){
            throw new NoSuchElementException("Employee with id=%d not found".formatted(id));
        }
        employeeRepository.deleteById(id);
    }
}
