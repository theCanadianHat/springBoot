package com.njh.springBoot.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.njh.springBoot.Student;
import com.njh.springBoot.service.StudentService;

@Controller
public class MyController {
	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String index(Model model){
		HashMap<Long, Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		
		return "index";
	}
	
	@RequestMapping("/addStudent")
	public void addStudent(@RequestParam(value="name") String name, @RequestParam(value="subject") String subject, Model model,
			HttpServletRequest request, HttpServletResponse response){
		studentService.addStudent(name, subject);
		this.index(model);
	}
	
	@RequestMapping("/removeStudent")
	public void removeStudent(@RequestParam(value="id")String id, Model model, HttpServletRequest request, HttpServletResponse response){
		studentService.removeStudent(id);
		this.index(model);
	}
}
