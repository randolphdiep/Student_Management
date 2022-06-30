package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;

@Repository
public interface StudentInfoRepository extends CrudRepository<StudentInfo, StudentIdentity> {
		
}
