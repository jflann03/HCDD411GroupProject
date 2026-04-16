package psu.edu.groupproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import psu.edu.groupproject.dao.EmployeeRepository;
import psu.edu.groupproject.entity.Person;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Person> findAll() {
		return employeeRepository.findAll();
	}
	
	
	
	@Override
	public Person findById(int theId) {
		
		Optional<Person> result = employeeRepository.findById(theId);
		
		Person thePerson= null;
		
		if (result.isPresent()) {
			thePerson = result.get();
		}
		else {
			//we did not find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return thePerson;
	}
	
	
	@Override
	public Person save(Person thePerson) {
		return employeeRepository.save(thePerson);
	}
	
	
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	

}