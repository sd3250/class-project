package ro.siit.concedii.service;

import org.springframework.stereotype.Service;
import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;

@Service
public class LeaveServiceIMPL implements LeaveService {
    @Override
    public Collection<Leave> search(String query) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Leave get(Long id) {
        return null;
    }

    @Override
    public void save(Leave leave) {

    }

    @Override
    public boolean update(Leave leave, Long id) {
        return false;
    }

    @Override
    public Collection<Leave> listAll() {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmpoyee(Employee employee) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmpoyeeID(Long id) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmpoyeeApproved(Employee employee) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmpoyeeApproved(Long id) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmpoyeeNotApproved(Employee employee) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmpoyeeNotApproved(Long id) {
        return null;
    }

    @Override
    public Integer getTotalNumersOfDaysAvailableByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Integer getTotalNumersOfDaysLeftByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Integer getTotalNumersOfDaysUsedByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Integer getTotalNumersOfDaysAvailableByEmployeeID(Long id) {
        return null;
    }

    @Override
    public Integer getTotalNumersOfDaysLeftByEmployeeID(Long id) {
        return null;
    }

    @Override
    public Integer getTotalNumersOfDaysUsedByEmployeeID(Long id) {
        return null;
    }
}
