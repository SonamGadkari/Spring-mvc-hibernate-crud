package com.springprj.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.springprj.entity.Student;

@Service
public interface StudentService {
	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudentDetails(int theId);

	public void deleteStudent(int theId);

}
