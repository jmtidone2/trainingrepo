package com.trainingsample.trainingsample.controller;

import com.trainingsample.trainingsample.exception.ResourceNotFoundException;
import com.trainingsample.trainingsample.model.Employee;
import com.trainingsample.trainingsample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<Page<Employee>> getEmployees(Pageable pageable){

        return ResponseEntity.ok(employeeService.getAllEmployees(pageable));
    }

    @GetMapping("/search")
    public  ResponseEntity<Page<Employee>> searchEmployees(@QueryParam("name") String name,
                                                           @QueryParam("salary") Double salary,
                                                           Pageable pageable){
        return ResponseEntity.ok(employeeService.search(name, salary, pageable));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "employeeId") Long id)
            throws ResourceNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
