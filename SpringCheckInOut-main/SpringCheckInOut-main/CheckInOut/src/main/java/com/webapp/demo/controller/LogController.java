package com.webapp.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.classlog.ClassLog;
import com.webapp.demo.dao.LogDao;

@RestController
public class LogController {
	@Autowired
	LogDao dao;
	@RequestMapping(path="/checkIn")
	@ResponseBody
	public void CheckIn(@RequestParam String name,ClassLog obj){
		obj.setLogType("in");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		obj.setDate(date.toString());
		obj.setTime(time.toString());
		obj.setId(name+time.toString());
		dao.save(obj);
		System.out.println("checkIn"+ name);
		
	}
	
	@RequestMapping(path="/checkOut")
	@ResponseBody
	public void CheckOut(@RequestParam String name,ClassLog obj){
		obj.setLogType("out");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		obj.setDate(date.toString());
		obj.setTime(time.toString());
		obj.setId(name+time.toString());
		dao.save(obj);
		System.out.println("checkout"+ name);
		
	}
	
	@RequestMapping(path="/getLog")
	@ResponseBody
	public List<ClassLog> GetLogByDate(@RequestParam String date,ClassLog obj){
		
		
		System.out.println("getLog"+ date);
		return dao.findAllByDate(date);
	
}
	@RequestMapping(path="/getAllLog")
	@ResponseBody
	public List<ClassLog> GetAllLog(){
		return dao.findAll();
	
}
	
}
