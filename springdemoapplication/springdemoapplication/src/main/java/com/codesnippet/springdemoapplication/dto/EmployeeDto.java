package com.codesnippet.springdemoapplication.dto;

import com.codesnippet.springdemoapplication.entity.Employee;

public class EmployeeDto {

    String name;
    String dept;
    Integer age;

    public EmployeeDto(String name, String dept, Integer age) {
    }

    public EmployeeDto() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public EmployeeDto EmployeeMapper(Employee employee){
        return new EmployeeDto(employee.getName(), employee.getDept(), employee.getAge());
    }
}
