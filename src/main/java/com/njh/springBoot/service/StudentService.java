package com.njh.springBoot.service;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njh.springBoot.Application;
import com.njh.springBoot.Student;


@RestController
@RequestMapping(value="/rest/student")
public class StudentService {
	
	   @RequestMapping(value="/",method = RequestMethod.GET)
	   public HashMap<Long,Student> getAllStudents(){
	      return Application.hmStudent;
	   }
	   
	   @RequestMapping(value="/add",method = RequestMethod.POST)
	   public Student addStudent(@RequestParam(value="name") String name,
			   					 @RequestParam(value="subject",defaultValue = "unknown") String subject){

	      Student student=new Student(name,subject);
	      Application.hmStudent.put(new Long(student.getId()),student);
	      return student;

	   }
	   
	   @RequestMapping(value="/update",method = RequestMethod.PUT)
	   public Student updateStudent(@RequestBody Student student) throws Exception {
	    
	      if(Application.hmStudent.containsKey(new Long(student.getId()))){
	         Application.hmStudent.put(new Long(student.getId()),student);
	      }else{
	         throw new Exception("Student "+student.getId()+" does not exists");
	      }
	    
	      return student;
	   }
	   
	   @RequestMapping(value="/{id}",method = RequestMethod.GET)
	   public String getStudent(@PathVariable long id, Model model){
		   model.addAttribute("studentId", id);
	      return "student";
	   }
}
