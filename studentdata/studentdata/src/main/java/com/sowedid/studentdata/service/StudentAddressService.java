package com.sowedid.studentdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowedid.studentdata.repository.StudentAddressRepository;

@Service
public class StudentAddressService {
	@Autowired
	private StudentAddressRepository addressRepository;

}
