package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.dto.EmployeeDto;
import com.codesnippet.springdemoapplication.entity.Employee;
import com.codesnippet.springdemoapplication.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
   private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeDto getEmployee(Integer id){
       logger.info("adding product in db");
       logger.error("be focus");
       logger.warn("warning");
       logger.debug("debug");
       logger.trace("trace");
       Employee employee= employeeRepository.getEmployee(id);
       EmployeeDto employeeDto=new EmployeeDto();
      return employeeDto.EmployeeMapper(employee);

    }

}
