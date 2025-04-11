package com.sowedid.studentdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowedid.studentdata.service.StudentAddressService;

@RestController
@RequestMapping("/studentAddress")
public class StudentSAddressController {
	@Autowired
	private StudentAddressService studentAddressService;
	

}
