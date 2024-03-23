package com.empManger.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;
}
