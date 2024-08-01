package com.lazarev.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String phone;

    @ManyToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}

