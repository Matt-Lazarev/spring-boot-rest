package com.lazarev.rest.service;

import com.lazarev.rest.dto.EmployeeAdditionRequest;
import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.entity.Employee;
import com.lazarev.rest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAllEmployees();
    }

    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeById(Integer id){
        Employee employee = employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with id=%d not found".formatted(id)));
        return new EmployeeDto(
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment().getName()
        );
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
        updatableEmployee.setEmail(employee.getEmail());
        updatableEmployee.setDepartment(employee.getDepartment());

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
