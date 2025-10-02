package net.javaguides.employee_service.service.Impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.spring6.fallback.FallbackMethod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.employee_service.dto.ApiResponeDto;
import net.javaguides.employee_service.dto.DepartmentDto;
import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.dto.OrganizationDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.mapper.EmployeeMapper;
import net.javaguides.employee_service.repository.EmployeeRepository;
import net.javaguides.employee_service.service.EmployeeService;
import net.javaguides.employee_service.service.OrganizationApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
   // private RestTemplate restTemplate;
   // private WebClient webClient;
    private  ApiClient apiClient;
    private OrganizationApiClient organizationApiClient;
   // private Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);

//    public EmployeeServiceImpl(EmployeeRepository employeeRepository,RestTemplate restTemplate) {
//        this.employeeRepository = employeeRepository;
//        this.restTemplate=restTemplate;
//    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployeea(employeeDto);


     Employee savedEmployee=   employeeRepository.save(employee);

     EmployeeDto employeeDto1=EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return employeeDto1;
    }

    @Override
   // @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public ApiResponeDto getEmployeeById(Long employeeId) {
        log.info("info getEployeeBy() id");
        Employee employee=employeeRepository.findById(employeeId).get();
//      ResponseEntity<DepartmentDto>responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//      DepartmentDto departmentDto=responseEntity.getBody();
//       DepartmentDto departmentDto=webClient.get()
//               .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//               .retrieve()
//               .bodyToMono(DepartmentDto.class)
//               .block();
      DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());
      OrganizationDto organizationDto=organizationApiClient.getOrganization(employee.getOrganizationCode());


        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponeDto apiResponeDto=new ApiResponeDto();
        apiResponeDto.setEmployee(employeeDto);
        apiResponeDto.setDepartment(departmentDto);
        apiResponeDto.setOrganization(organizationDto);
        return apiResponeDto;
    }
    public ApiResponeDto getDefaultDepartment(Long employeeId,Throwable throwable) {
        Employee employee=employeeRepository.findById(employeeId).get();
       // DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D department");
        departmentDto.setDepartmentDescription("Research and devlopment department");
        departmentDto.setDepartmentCode("RD001");


        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponeDto apiResponeDto=new ApiResponeDto();
        apiResponeDto.setEmployee(employeeDto);
        apiResponeDto.setDepartment(departmentDto);
        return apiResponeDto;
    }

    }
