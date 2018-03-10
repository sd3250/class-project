/**
 * TREBUIE PUSE DEPENDENTE IN POM.XML
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
    @RequestMapping(value = "/cages", method = RequestMethod.GET)
    public String listCages(Model model) {
        Collection<Employee> employees = employeeService.listAll();
        model.addAttribute("employees", employees);
        return "listCages";

    }

    @RequestMapping(value = "/cages", method = RequestMethod.POST)
    public String createCage(Employee employee, Model model) {
        Collection<Employee> employees = employeeService.listAll();
        employeeService.createEmployee(employee);
        model.addAttribute("employees", employees);


        return "listCages";
    }

    @RequestMapping(value = "/prepare/Employee", method = RequestMethod.GET)
    public String prepareEmployee(Model model) {

        model.addAttribute("emploryee", new Employee());
        return "createEmployee";
    }
}
