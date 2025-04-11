package com.sowedid.studentdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowedid.studentdata.model.StudentAddress;

public interface StudentAddressRepository  extends JpaRepository<StudentAddress,Long>{

}
