package com.example.spring_learn.service;

import com.example.spring_learn.models.Employee;
import com.example.spring_learn.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees(){
        return employeeDao.findAll();
    }

    public Employee saveEmployee(Employee e){
        return employeeDao.save(e);
    }

    public void deleteEmployeeById(Long id){
        employeeDao.deleteById(id);
    }
}
