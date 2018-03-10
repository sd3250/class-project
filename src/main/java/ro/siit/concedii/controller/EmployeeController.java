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
import ro.siit.concedii.service.EmployeeServiceIMPL;
import ro.siit.concedii.service.ValidationException;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Controller
public class EmployeeController {
    private void addData() throws ValidationException {
        Employee e1 = new Employee("jon", "doe", new Date(), Gender.MALE, new Date(), "dasdsa", 23132);
        Employee e2 = new Employee("jon", "doe", new Date(), Gender.MALE, new Date(), "dasdsa", 23132);
        employeeService.save(e1);
        employeeService.save(e2);
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public String employee(@RequestParam(value = "employee", required = false, defaultValue = "") Employee employee, Model model) throws ValidationException {
        try {
            addData();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        model.addAttribute("employee", employee);
        return "employeee";

    }

    @RequestMapping(value = "/employee/all", method = RequestMethod.GET)
    public String listEmployee(Model model) {
        Collection<Employee> employees = employeeService.listAll();
        model.addAttribute("employees", employees);
        return "allemployees";

    }

    @RequestMapping(value = "/employee/update", method = RequestMethod.POST)
    public String EmployeeUpdate() {
        return null;
    }

    @RequestMapping(value = "/employee/delete", method = RequestMethod.POST)
    public String EmployeeDelete() {
        return null;
    }

    @RequestMapping(value = "/employee/search", method = RequestMethod.GET)
    public String EmployeeSearch() {

        return null;
    }

    @RequestMapping(value = "/employee/validate", method = RequestMethod.GET)
    public String EmployeeValidate() {

        return null;
        
    }

    //get->list all
    //search->get Search Post form
    //delete->get

}
