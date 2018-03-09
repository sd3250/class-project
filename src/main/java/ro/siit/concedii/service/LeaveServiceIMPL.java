package ro.siit.concedii.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.siit.concedii.dao.LeaveDAO;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class LeaveServiceIMPL implements LeaveService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveServiceIMPL.class);

    private LeaveDAO dao;

    public LeaveDAO getDao() {
        return dao;
    }

    public void setDao(LeaveDAO dao) {
        this.dao = dao;
    }

    @Override
    public Collection<Leave> search(String query) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.debug("Deleting leave for id: " + id);
        Leave leave = dao.findById(id);
        if (leave != null) {
            dao.delete(leave);
            return true;
        }

        return false;
    }

    @Override
    public Leave get(Long id) {
        LOGGER.debug("Getting leave for id: " + id);
        return dao.findById(id);
    }

    @Override
    public void save(Leave leave) {
        LOGGER.debug("Saving: " + leave);

        dao.add(leave);
    }

    @Override
    public boolean update(Leave leave, Long id) {
        if (dao.update(leave,id)) {
            LOGGER.debug("Updateing: " + leave);
            return true;
        } else {
            LOGGER.debug("Can't update leave, id not found: " + id);
            return false;
        }
    }

    @Override
    public Collection<Leave> listAll() {
        return dao.getAll();
    }


    @Override
    public Collection<Leave> listAllByEmployeeID(Long id) {
        Collection<Leave> leaves;
        leaves = listAll();
        return Collections.singleton(leaves.stream().filter(c -> c.getEmployeeID() == id).collect(Collectors.toList()).get(0));
    }


    @Override
    public Collection<Leave> listAllByEmployeeApproved(Long id) {
        Collection<Leave> leaves;
        leaves = listAll();
        return Collections.singleton(leaves.stream().filter(c -> c.getEmployeeID() == id && c.getApproved()).collect(Collectors.toList()).get(0));
    }


    @Override
    public Collection<Leave> listAllByEmployeeNotApproved(Long id) {
        Collection<Leave> leaves;
        leaves = listAll();
        return Collections.singleton(leaves.stream().filter(c -> c.getEmployeeID() == id && !c.getApproved()).collect(Collectors.toList()).get(0));

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
