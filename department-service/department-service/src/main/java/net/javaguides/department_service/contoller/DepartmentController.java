package net.javaguides.department_service.contoller;

import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping()
    public ResponseEntity<DepartmentDto>saveDepartment(@RequestBody  DepartmentDto departmentDto){
      DepartmentDto savedDepartemt=  departmentService.saveDepartment(departmentDto);
      return new ResponseEntity<>(savedDepartemt,HttpStatus.CREATED);
    }
    @GetMapping("{department-Code}")
    public ResponseEntity<DepartmentDto>getDepartment(@PathVariable("department-Code") String departmentCode){
       DepartmentDto departmentDto= departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
