package com.lazarev.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employee.setDepartment(this);
        this.employees.add(employee);
    }
}
