package net.javaguides.employee_service.service;

import net.javaguides.employee_service.dto.ApiResponeDto;
import net.javaguides.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponeDto getEmployeeById(Long employeeId );
}
