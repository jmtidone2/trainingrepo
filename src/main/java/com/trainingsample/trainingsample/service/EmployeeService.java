package com.trainingsample.trainingsample.service;

import com.trainingsample.trainingsample.exception.ResourceNotFoundException;
import com.trainingsample.trainingsample.model.Employee;
import com.trainingsample.trainingsample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Page<Employee> search(String name, Double salary, Pageable pageable) {

        //I couldn't check isNullOrEmpty in the same line (below)
        if(name == null)
        {
            name = "";  
        }

        if (!name.isEmpty() && salary != null) {
            return employeeRepository.findByNameIgnoreCaseContainingAndSalaryGreaterThan(name, salary, pageable);
        } else {

            if (!name.isEmpty()) {
                return employeeRepository.findByNameIgnoreCaseContaining(name, pageable);
            } else {
                return employeeRepository.findBySalaryGreaterThan(salary, pageable);
            }
        }

    }

    public Employee getEmployee(Long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id "+ id +" cannot be found"));
    }

}


