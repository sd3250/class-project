package ro.siit.concedii.mocking;

import ro.siit.concedii.dao.LeaveDAO;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class IMLeaveDAO extends IMBaseDAO<Leave> implements LeaveDAO {
    @Override

    public Collection<Leave> searchByEmployeeID(long employeeID) {
        Collection<Leave> all = new LinkedList<Leave>(getAll());
        for (Iterator<Leave> it = all.iterator(); it.hasNext();) {
            Leave leave = it.next();
            if (employeeID != leave.getId() ) {
                it.remove();
            }
        }
        return all;
    }
}
