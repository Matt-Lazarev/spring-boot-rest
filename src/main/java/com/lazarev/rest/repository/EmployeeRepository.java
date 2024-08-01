package com.lazarev.rest.repository;

import com.lazarev.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e left join fetch e.department")
    List<Employee> findAllEmployees();
}
