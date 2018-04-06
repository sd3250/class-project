package ro.siit.concedii.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.service.EmployeeService;
import ro.siit.concedii.service.ValidationException;

import java.util.Collection;
/*
https://spring.io/guides/tutorials/bookmarks/
 */

@RestController
@RequestMapping(value = "/api/employee", method = RequestMethod.GET)
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("")
    public Collection<Employee> list() {
        return employeeService.listAll();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable Employee input) throws ValidationException {
        return employeeService.save(input);
    }
}
