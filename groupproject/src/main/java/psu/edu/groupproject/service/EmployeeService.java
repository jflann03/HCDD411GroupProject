package psu.edu.groupproject.service;

import java.util.List;

import psu.edu.groupproject.entity.Person;



public interface EmployeeService {
	
	List<Person> findAll();

	Person findById(int theId);
	
	Person save(Person thePerson);
	
	void deleteById(int theId);

}
