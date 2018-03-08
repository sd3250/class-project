package ro.siit.concedii.service;

import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;

public interface LeaveService {

    public Collection<Leave> search( String query) ;

    public boolean delete(Long id) ;

    public Leave get(Long id) ;

    public void save(Leave leave);

    public boolean update(Leave leave, Long id);

    public Collection<Leave> listAll();

    public Collection<Leave> listAllByEmpoyee(Employee employee);

    public Collection<Leave> listAllByEmpoyeeID(Long id);

    public Collection<Leave> listAllByEmpoyeeApproved(Employee employee);

    public Collection<Leave> listAllByEmpoyeeApproved(Long id);

    public Collection<Leave> listAllByEmpoyeeNotApproved(Employee employee);

    public Collection<Leave> listAllByEmpoyeeNotApproved(Long id);

    public Integer getTotalNumersOfDaysAvailableByEmployee(Employee employee);

    public Integer getTotalNumersOfDaysLeftByEmployee(Employee employee);

    public Integer getTotalNumersOfDaysUsedByEmployee(Employee employee);

    public Integer getTotalNumersOfDaysAvailableByEmployeeID(Long id);

    public Integer getTotalNumersOfDaysLeftByEmployeeID(Long id);

    public Integer getTotalNumersOfDaysUsedByEmployeeID(Long id);
}
