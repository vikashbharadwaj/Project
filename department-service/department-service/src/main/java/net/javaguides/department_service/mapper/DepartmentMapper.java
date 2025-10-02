package net.javaguides.department_service.mapper;

import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;

    }
    public  static Department mapToDepartment(DepartmentDto departmentDto){
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()

        );
        return department;


    }

}
