package com.springprj.dao;

import java.util.List;

import com.springprj.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudentDetails(int theId);

	public void deleteStudent(int theId);
	
}
