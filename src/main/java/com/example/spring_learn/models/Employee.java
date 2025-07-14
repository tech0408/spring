package com.example.spring_learn.models;

import com.example.spring_learn.repository.AddressDao;
import jakarta.persistence.*;

import java.util.List;

/*
    1. Every class that is mapped to a table in DB should be declared with @Entity annotation.
    2. By default, the name of the class is the table name.
    3. If we want to customise the table name or use a different table name from class name,
       we can use @Table annotation.
 */
@Entity
public class Employee {

    public enum JobType{

        FULL_TIME, PART_TIME, CONTRACT
    }

    /*
        1. @Id is used to define a field as a primary key in the table.
        2. Every entity class must have exactly one field annotated with @Id.

     */
    @Id

    /*
        1. @GeneratedValue annotation is used only with @Id -> that is for the primary key.
        2. It specifies the auto-generation strategy for the primary key.
     */
    @GeneratedValue(strategy = GenerationType.TABLE) // strategies -> IDENTITY (relies on auto-increment columns of DB)
    // AUTO -> hibernate decides the strategy, defaults to db specific behaviour.
    // SEQUENCE -> uses a DB sequence to generate a primary key value.
    // TABLE -> uses a sequence table maintained by hibernate to generate keys.
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String department;

    private Double salary;

    // By default, EnumType.ORDINAL is applied, and it stores 0,1,2 ie ordinals.
    @Enumerated(EnumType.STRING) // value of this field is defined by Enum.
    private JobType jobType;

    //@Transient [use this when we don't want to persist any field in DB]
    private String profile;

//    @ManyToOne
//    @JoinColumn(name ="dpt_id")
//    private Department dpt;

    // Unidirectional one to one mapping.
//    @OneToOne
//    @JoinColumn(name="address_id") // @JoinColumn is used to define the foreign key.
//    // Here a foreign key address_id is generated for Employee table which refers to primary key id in Address table.
  //  private Address address;

    // Bidirectional one to one mapping.
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;


    // ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dppt_id")
    private Department dpt;


    // Many to many
    @ManyToMany
    @JoinTable(name="student_course",
    joinColumns=@JoinColumn(name="employee_id"))
    private List<Course> courses;


    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;

        if(address!= null){
            address.setEmployee(this);
        }
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setDpt(Department dpt) {
        this.dpt = dpt;
//        if(dpt!=null){
//            dpt.setEmployees(List.of(this));
//        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
