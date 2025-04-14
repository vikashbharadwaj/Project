package com.codesnippet.springdemoapplication.repository;

import com.codesnippet.springdemoapplication.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {


    public Employee getEmployee(Integer id) {
        return  new Employee(1,"vikas","it",27);
    }
}