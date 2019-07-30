package com.springprj.dao;

import java.util.Comparator;
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
	public List<Student> getStudents() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Student> theQuery = 
				currentSession.createQuery("from Student order by last_name", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();	
		
		// return the results		
		return students;
	}

	@Override
	public void saveStudent(Student theStudent) {
		// TODO Auto-generated method stub		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public Student getStudentDetails(int theId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
        //Query<Student> sQuery= session.createQuery("from Student where id=theId",Student.class);
        Student theStudent=session.get(Student.class, theId);
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		Student stu=session.get(Student.class, theId);
		session.remove(stu);
	}
	
}