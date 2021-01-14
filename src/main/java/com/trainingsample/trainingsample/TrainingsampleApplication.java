package com.trainingsample.trainingsample;

import com.trainingsample.trainingsample.model.Department;
import com.trainingsample.trainingsample.model.Employee;
import com.trainingsample.trainingsample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TrainingsampleApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrainingsampleApplication.class, args);
	}

	@PostConstruct
	private void loadData(){


		Employee emp1 = new Employee((long)1,"Juan Manuel", 222.22, null);

		Department dep1 = new Department((long)1, "Department One", null);
		emp1.setDepartment(dep1);

		Employee emp2 = new Employee((long)2,"Andres", 111.22, null);

		Department dep2 = new Department((long)2, "Department Two", null);
		emp2.setDepartment(dep2);

		Employee emp3 = new Employee((long)3,"Juan Ignacio", 325.5, null);

		Department dep3 = new Department((long)3, "Department Three", null);
		emp3.setDepartment(dep3);

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);



	}

}


