package ro.siit.concedii.dao;

import ro.siit.concedii.domain.Leave;

import java.util.Collection;

public interface LeaveDAO extends BaseDAO<Leave>{
    Collection<Leave> searchByEmployeeID(long employeeID);
//    long addBy //	//shout retun id

}
