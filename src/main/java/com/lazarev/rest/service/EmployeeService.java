package com.lazarev.rest.service;

import com.lazarev.rest.dto.EmployeeAdditionRequest;
import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.entity.Employee;
import com.lazarev.rest.repository.EmployeeRepository;
import com.lazarev.rest.service.mapper.MapstructEmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    //private final EmployeeMapper employeeMapper;
    private final MapstructEmployeeMapper employeeMapper;

    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAllEmployees();
        return employeeMapper.toDtoList(employees);
    }

    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeById(Integer id){
        Employee employee = employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with id=%d not found".formatted(id)));

        return employeeMapper.toDto(employee);
    }

    @Transactional
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(Integer id, EmployeeDto employeeDto){
        Employee updatableEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with id=%d not found".formatted(id)));

        employeeMapper.update(updatableEmployee, employeeDto);

        employeeRepository.save(updatableEmployee);
    }

    @Transactional
    public void deleteEmployeeById(Integer id){
        if(!employeeRepository.existsById(id)){
            throw new NoSuchElementException("Employee with id=%d not found".formatted(id));
        }
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getByIdOrDefault(EmployeeAdditionRequest employeeAdditionRequest){
        if(employeeAdditionRequest.getEmployeeId() == null){
            Employee employee = new Employee();
            employee.setName(employeeAdditionRequest.getName());
            employee.setEmail(employeeAdditionRequest.getEmail());
            return Optional.of(employee);
        }
        return employeeRepository.findEmployeeById(employeeAdditionRequest.getEmployeeId());
    }
}
