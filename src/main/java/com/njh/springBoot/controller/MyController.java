package com.njh.springBoot.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.njh.springBoot.Student;
import com.njh.springBoot.service.StudentService;

@Controller
public class MyController {
	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/sup")
	public String sup(@RequestParam(value="name", required=false, defaultValue="bitches")String name,
			Model model){
		model.addAttribute("studentId", "bitches");
		return "student";
	}
	
	@RequestMapping("/")
	public String index(Model model){
		HashMap<Long, Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		
		return "index";
	}
	
	public String addStudent(String name, String subject){
		return null;
		
	}
}
