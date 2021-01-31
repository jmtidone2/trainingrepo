package com.trainingsample.trainingsample.service;

import com.trainingsample.trainingsample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    //Merge fixed
    @Autowired
    private DepartmentRepository departmentRepository;
}
