/**
 * ce?
 */
package ro.siit.concedii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.domain.Gender;
import ro.siit.concedii.service.EmployeeService;
import ro.siit.concedii.service.ValidationException;

import java.util.Collection;
import java.util.Date;



@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public String employee(@RequestParam(value = "firstname", required = false, defaultValue = "First name")String firstname, Model model,
                           @RequestParam(value = "lastname", required = false, defaultValue = "Last name") String lastname,
                           @RequestParam(value = "birthdate", required = false, defaultValue = "War") Date birthdate,
                           @RequestParam(value = "gender", required = false, defaultValue = "UNSPECIFIED") Gender gender,
                           @RequestParam(value = "jobTitle", required = false, defaultValue = "War") String jobTitle,
                           @RequestParam(value = "salary", required = false, defaultValue = "War") double salary){

        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        model.addAttribute("birthdate", birthdate);
        model.addAttribute("gender", gender);
        model.addAttribute("jobTitle", jobTitle);
        model.addAttribute("salary",salary);
        return "employeee";
    }

/*
for what?
 */

    @RequestMapping(value = "/prepare/Employee", method = RequestMethod.GET)
    public String prepareEmployee(Model model) {

        model.addAttribute("emploryee", new Employee());
        return "createEmployee";
    }
}
