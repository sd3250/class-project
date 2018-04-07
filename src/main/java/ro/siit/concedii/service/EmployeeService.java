package ro.siit.concedii.service;

import org.springframework.http.ResponseEntity;
import ro.siit.concedii.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    public Collection<Employee> listAll();

    @Deprecated
    public Collection<Employee> search( String query) ;

    public boolean delete(Long id) ;

    public Employee get(Long id) ;

    public ResponseEntity<?> save(Employee employee)throws ValidationException;

    public boolean update(Employee employee, Long id) throws ValidationException;
}
