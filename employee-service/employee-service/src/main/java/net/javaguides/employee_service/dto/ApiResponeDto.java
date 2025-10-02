package net.javaguides.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponeDto {
    private EmployeeDto employee;
    private  DepartmentDto department;
    private  OrganizationDto organization;
}
