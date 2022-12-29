package com.webapp.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.classlog.ClassLog;

public interface LogDao extends JpaRepository<ClassLog,Integer >{
	
	@Query(value="select * from class_log where date= ?1",nativeQuery = true)
	List<ClassLog> findAllByDate(String date);
}
