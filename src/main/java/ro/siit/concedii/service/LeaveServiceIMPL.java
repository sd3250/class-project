package ro.siit.concedii.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.siit.concedii.dao.LeaveDAO;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;
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
        return dao.searchByEmployeeID(id);
    }


    @Override
    public Collection<Leave> listAllByEmployeeIDApproved(Long id) {
        Collection<Leave> leaves;
        leaves = dao.searchByEmployeeID(id);
        return leaves.stream().filter(c -> c.getApproved()).collect(Collectors.toList());
    }


    @Override
    public Collection<Leave> listAllByEmployeeIDNotApproved(Long id) {
        Collection<Leave> leaves;
        leaves = listAll();
        return leaves.stream().filter(c -> !c.getApproved()).collect(Collectors.toList());

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
    public Integer getMaximumNoDaysForEmployeeID(long id) {
        return null;
    }

    @Override
    public boolean approveLeaveByID(Long id) {
        return dao.findById(id).getApproved();
    }


    @Override
    public boolean rejectLeaveByID(Long id) {
        return !dao.findById(id).getApproved();
    }

}
