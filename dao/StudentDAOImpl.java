package com.springprj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springprj.entity.Student;



@Repository
public class StudentDAOImpl implements StudentDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Student> theQuery = 
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
				
		// return the results		
		return students;
	}
}