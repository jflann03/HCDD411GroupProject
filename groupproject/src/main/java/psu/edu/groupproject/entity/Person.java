package psu.edu.groupproject.entity;
/* HCDD 411 Group Project 
* Person.java
* 04/19/2025
*/


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="employees")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
    private int employeeId; // unique employee_ID
	
	@Column(name="last_name")
	private String lastName; // employee name field
	
	@Column(name="first_name")
	private String firstName; // employee name field
	
	@Column(name="salary")
	 private Double salary; // use Double to allow null
	
	@Column(name="start_date")
	private Date startDate; // employment start date 
	
	@Column(name="employee_contract_signed")
	private Boolean employeeContractSigned; // shows if employer has signed contract 
	
	@Column(name="social_security_number")
	private String socialSecurityNumber; // social security number
	
	@Column(name="birthday")
    private Date birthday; // unique employee_ID 
	
	@Column(name="phoneNumber")
    private String phoneNumber;
	
	@Column(name="emergency_contact_name")
    private String emergencyContactName;
	
	@Column(name="emergency_contact_phone_number")
    private String emergencyContactPhoneNumber;                 
	

    // full constructor (optional)
    public Person(int employeeId, String lastName, String firstName, Double salary, Date startDate,
                  Boolean employeeContractSigned, String socialSecurityNumber, Date birthday,
                  String phoneNumber, String emergencyContactName, String emergencyContactPhoneNumber) {

        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.startDate = startDate;
        this.employeeContractSigned = employeeContractSigned;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }
	// Getters & Setters

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Boolean getEmployeeContractSigned() {
		return employeeContractSigned;
	}

	public void setEmployeeContractSigned(Boolean employeeContractSigned) {
		this.employeeContractSigned = employeeContractSigned;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhoneNumber() {
		return emergencyContactPhoneNumber;
	}

	public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}
}