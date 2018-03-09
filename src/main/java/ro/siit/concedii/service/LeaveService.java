package ro.siit.concedii.service;

import ro.siit.concedii.domain.Leave;

import java.util.Collection;

public interface LeaveService {

    public Collection<Leave> search( String query) ;

    public boolean delete(Long id) ;

    public Leave get(Long id) ;

    public void save(Leave leave);

    public boolean update(Leave leave, Long id);

    public Collection<Leave> listAll();


    public Collection<Leave> listAllByEmployeeID(Long id);

    public Collection<Leave> listAllByEmployeeIDApproved(Long id);

    public Collection<Leave> listAllByEmployeeIDNotApproved(Long id);

    public Integer getTotalNumberOfDaysAvailableByEmployeeID(Long id);

    public Integer getTotalNumberOfDaysLeftByEmployeeID(Long id);

    public Integer getTotalNumberOfDaysUsedByEmployeeID(Long id);

    public boolean approveLeaveByID(Long id);

    public boolean approveLeaveByLeave(Leave leave);

    public boolean rejectLeaveByID(Long id);

    public boolean rejectLeaveByLeave(Leave leave);
}
