package com.example.spring_learn.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Unidirectional
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="department_id")
//    private List<Employee> employees;

    // Bidirectional
//    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
//    private List<Employee> employees;
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }

//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    public void setName(String name) {
        this.name = name;
    }
}
