package psu.edu.groupproject.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = "Salary is required")
    @Column(name = "salary", nullable = false)
    private Double salary;

    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date cannot be in the future")
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @NotNull(message = "Status of contract is required")
    @Column(name = "employee_contract_signed", nullable = false)
    private Boolean employeeContractSigned;

    @NotBlank(message = "SSN is required")
    @Column(name = "social_security_number", nullable = false)
    private String socialSecurityNumber;

    @NotNull(message = "Birthday is required")
    @Past(message = "Birthdate must be in the past")
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @NotBlank(message = "Phone number is required")
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Emergency contact name is required")
    @Column(name = "emergency_contact_name", nullable = false)
    private String emergencyContactName;

    @NotBlank(message = "Emergency contact phone number is required")
    @Column(name = "emergency_contact_phone_number", nullable = false)
    private String emergencyContactPhoneNumber;

    public Person() {
    }

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