package net.javaguides.employee_service.controller;

import net.javaguides.employee_service.dto.ApiResponeDto;
import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeDto>saveEmployee(@RequestBody EmployeeDto employeeDto){
     EmployeeDto saved= employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponeDto>getEmployee(@PathVariable("id") Long employeeId){
     ApiResponeDto apiResponeDto=   employeeService.getEmployeeById(employeeId);
        return  new ResponseEntity<>(apiResponeDto,HttpStatus.OK);
    }
}
