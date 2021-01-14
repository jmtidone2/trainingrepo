package com.trainingsample.trainingsample.repository;

import com.trainingsample.trainingsample.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    Page<Employee>  findByNameIgnoreCaseContainingAndSalaryGreaterThan(String name, Double salary, Pageable pageable);
    Page<Employee>  findBySalaryGreaterThan(Double salary, Pageable pageable);
    Page<Employee>  findByNameIgnoreCaseContaining(String name, Pageable pageable);
}
