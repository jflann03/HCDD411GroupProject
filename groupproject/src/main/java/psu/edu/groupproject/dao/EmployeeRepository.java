package psu.edu.groupproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import midterm3.employeedb.entity.Employee;
import psu.edu.groupproject.entity.Person;


public interface EmployeeRepository extends JpaRepository<Person, Integer>{

}
