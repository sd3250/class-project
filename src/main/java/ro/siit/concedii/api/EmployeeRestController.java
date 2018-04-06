package ro.siit.concedii.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.service.EmployeeService;

import java.util.Collection;


@RestController
@RequestMapping(value = "/api/employee", method = RequestMethod.GET)
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("")
    public Collection<Employee> list(){
        return employeeService.listAll();
    }
}
