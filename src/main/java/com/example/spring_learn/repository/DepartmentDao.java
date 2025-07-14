package com.example.spring_learn.repository;

import com.example.spring_learn.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Long> {
}
