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
    public Collection<Leave> listAllByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmployeeID(Long id) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmployeeApproved(Employee employee) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmployeeApproved(Long id) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmployeeNotApproved(Employee employee) {
        return null;
    }

    @Override
    public Collection<Leave> listAllByEmployeeNotApproved(Long id) {
        return null;
    }

    @Override
    public Integer getTotalNumberOfDaysAvailableByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Integer getTotalNumberOfDaysLeftByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Integer getTotalNumberOfDaysUsedByEmployee(Employee employee) {
        return null;
    }

    @Override
    public Integer getTotalNumberOfDaysAvailableByEmployeeID(Long id) {
        return null;
    }

    @Override
    public Integer getTotalNumberOfDaysLeftByEmployeeID(Long id) {
        return null;
    }

    @Override
    public Integer getTotalNumberOfDaysUsedByEmployeeID(Long id) {
        return null;
    }

    @Override
    public boolean approveLeaveByID(Long id) {
        return false;
    }

    @Override
    public boolean approveLeaveByLeave(Leave leave) {
        return false;
    }

    @Override
    public boolean rejectLeaveByID(Long id) {
        return false;
    }

    @Override
    public boolean rejectLeaveByLeave(Leave leave) {
        return false;
    }
}
