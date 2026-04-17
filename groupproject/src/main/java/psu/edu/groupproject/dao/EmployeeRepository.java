package psu.edu.groupproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import psu.edu.groupproject.entity.Person;

public interface EmployeeRepository extends JpaRepository<Person, Integer>{

}
