package net.javaguides.department_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.mapper.DepartmentMapper;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;



    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

         Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);

        DepartmentDto savedDepartmentdto=DepartmentMapper.mapDepartmentDto(savedDepartment);
        return savedDepartmentdto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto=DepartmentMapper.mapDepartmentDto(department);

        return departmentDto;
    }
}
