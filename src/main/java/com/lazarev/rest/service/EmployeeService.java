package com.lazarev.rest.service;

import com.lazarev.rest.dto.EmployeeAdditionRequest;
import com.lazarev.rest.dto.EmployeeAdditionResponse;
import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.entity.Department;
import com.lazarev.rest.entity.Employee;
import com.lazarev.rest.mapper.EmployeeMapper;
import com.lazarev.rest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final EmployeeMapper employeeMapper;

    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees(){
        return employeeRepository.findAllEmployees().stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeById(Integer id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with id='%d' not found".formatted(id)));
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

    public EmployeeAdditionResponse addEmployeeToDepartment(EmployeeAdditionRequest employeeAdditionRequest) {
        //Работник есть в БД
        Employee employee;
        if(employeeAdditionRequest.getId() != null) {
            try {
                employee = employeeRepository.findById(employeeAdditionRequest.getId())
                        .orElseThrow(() -> new NoSuchElementException("Employee not found"));
            }
            catch (NoSuchElementException ex) {
                return new EmployeeAdditionResponse(
                        false,
                        "Error during adding employee to department: " + ex.getMessage()
                );
            }
        }
        //Работника нет в БД
        else {
            employee = new Employee();
            employee.setName(employeeAdditionRequest.getName());
            employee.setEmail(employeeAdditionRequest.getEmail());
        }

        //Отдел есть в БД
        if(employeeAdditionRequest.getDepartmentId() != null) {
            try {
                Department department = departmentService.getDepartmentById(employeeAdditionRequest.getDepartmentId());
                employee.setDepartment(department);
            }
            catch (NoSuchElementException ex) {
                return new EmployeeAdditionResponse(
                        false,
                        "Error during adding employee to department: " + ex.getMessage()
                );
            }
        }
        //Отдела нет в БД
        else {
            Department department = departmentService.createDepartment(employeeAdditionRequest);
            employee.setDepartment(department);
        }

        employeeRepository.save(employee);
        return new EmployeeAdditionResponse(true, "Employee added to department");
    }
}
