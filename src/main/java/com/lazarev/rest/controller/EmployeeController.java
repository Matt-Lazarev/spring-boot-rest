package com.lazarev.rest.controller;

import com.lazarev.rest.dto.EmployeeDto;
import com.lazarev.rest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    // /api/departments/{id}/add-employee
    @PostMapping
    public void saveEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id,
                               @RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }
}
