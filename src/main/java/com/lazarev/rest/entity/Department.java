package com.lazarev.rest.entity;

import jakarta.persistence.*;
import lombok.*;


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
}
