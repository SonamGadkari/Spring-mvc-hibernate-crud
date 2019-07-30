package com.springprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springprj.dao.StudentDAO;
import com.springprj.entity.Student;
import com.springprj.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	// need to inject the student dao
	//@Autowired
	//private StudentDAO studentDAO;
	//need to inject the student service
	@Autowired
	private StudentService studentService; 
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		// get students from the dao
		List<Student> thestudents = studentService.getStudents();
		//List<Student> thestudents = studentDAO.getStudents();
		// add the students to the model
		theModel.addAttribute("students", thestudents);	
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel)
	{		
		//This is for binding the data
		Student theStudent=new Student();
	    theModel.addAttribute("student",theStudent);
		return "student-form";
	}
	
	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent)	
	{
		studentService.saveStudent(theStudent);
		return "redirect:/student/list";		
	}
	
	//Because for the below the form is in the format loca..../showFormForUpdate?studentId=1
	@GetMapping("/showFormForUpdate")
	public String updateData(@RequestParam("studentId") int theId,Model theModel) 
	{
		//theModel
		Student theStudent=studentService.getStudentDetails(theId);
		theModel.addAttribute("student", theStudent); 
		return "student-update-form";
	}
	
	
	@GetMapping("/deleteAction")
	public String deleteAction(@RequestParam("studentId") int theId)
	{
		studentService.deleteStudent(theId);
		/*
		List<Student> thestudents = studentService.getStudents();
		theModel.addAttribute("students",thestudents);
		return "list-students";*/
		return "redirect:/student/list";
	}
	
}

