package com.example.spring_learn.controller;

import com.example.spring_learn.models.Address;
import com.example.spring_learn.models.Course;
import com.example.spring_learn.models.Department;
import com.example.spring_learn.models.Employee;
import com.example.spring_learn.repository.AddressDao;
import com.example.spring_learn.repository.CourseDao;
import com.example.spring_learn.repository.DepartmentDao;
import com.example.spring_learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private CourseDao courseDao;

//    @GetMapping
//    public List<Employee> getEmployees(){
//        return employeeService.getEmployees();
//    }

    @GetMapping
    public Employee saveEmployee(){

        Employee e = new Employee();
        e.setName("SawanKumar445");
        //e.setDepartment("CSE");
        e.setSalary(90000.0);
        e.setJobType(Employee.JobType.FULL_TIME);

        Employee e1 = new Employee();
        e1.setName("SawanKumar4445");
        //e.setDepartment("CSE");
        e.setSalary(90700.0);
        e.setJobType(Employee.JobType.FULL_TIME);

        Course course1 = new Course();
        course1.setName("Java");
        courseDao.save(course1);

        Course course2 = new Course();
        course2.setName("Python");
        courseDao.save(course2);

        Course course3 = new Course();
        course3.setName("Linux");
        courseDao.save(course3);

        e1.setCourses(List.of(course1,course2));
        e.setCourses(List.of(course1,course2,course3));





//        Department dpt = new Department();
//        dpt.setName("CSE");
//        //departmentDao.save(dpt);
//        //dpt.setEmployees(List.of(e));
//        e.setDpt(dpt);
//        e1.setDpt(dpt);


//        Address ad = new Address();
//        ad.setCity("Patna");
//        ad.setStreet("Kannu lal road");
//        e.setAddress(ad);
        employeeService.saveEmployee(e1);
        return employeeService.saveEmployee(e);

        //return departmentDao.save(dpt);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

}
