package psu.edu.groupproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import psu.edu.groupproject.entity.Person;
import psu.edu.groupproject.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class GroupProjectController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public GroupProjectController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Person> employees = employeeServiceImpl.findAll();

        model.addAttribute("employees", employees);

        return "employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Person employee = new Person();

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int employeeId,
                                    Model model) {

        Person employee = employeeServiceImpl.findById(employeeId);

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Person employee) {

        employeeServiceImpl.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {

        employeeServiceImpl.deleteById(employeeId);

        return "redirect:/employees/list";
    }
}