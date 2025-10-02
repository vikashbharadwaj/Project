package net.javaguides.employee_service.service.Impl;

import net.javaguides.employee_service.dto.DepartmentDto;
import net.javaguides.employee_service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("api/departments/{department-Code}")
    DepartmentDto getDepartment(@PathVariable("department-Code") String departmentCode);


    }
