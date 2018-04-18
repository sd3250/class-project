package ro.siit.concedii.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.service.EmployeeService;
import ro.siit.concedii.service.EmployeeServiceIMPL;
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

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    boolean update(@PathVariable Employee input, Long id) throws ValidationException {
        return employeeService.update(input, id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable ("id") Long id) {
        return employeeService.get(id);
    }
}
