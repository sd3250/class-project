package ro.siit.concedii.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.dao.LeaveDAO;
import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.domain.Leave;


import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

@Service
public class LeaveServiceIMPL implements LeaveService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveServiceIMPL.class);

    private LeaveDAO dao;

    private EmployeeDAO employeeDAO;

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
    public Integer getTotalNumberOfDaysAvailableByEmployeeID(Long id){
        Collection<Leave> leaves;
        leaves = listAllByEmployeeIDApproved(id);
        //nu iau in calcul o cerere care a fost inregistrata anul trecut, presupunem ca un concediu care e de pe un an pe altu e in doua cereri
        leaves =  leaves.stream().filter(c -> (c.getStartDate().after(getFirstDateOfYear()) || (c.getStartDate().equals(getFirstDateOfYear())))).collect(Collectors.toList());
        int count = 0;
        for (Leave leave: leaves
                ) {
            count = count + leave.getNoDays();

        }

        return getMaximumNoDaysForEmployeeID(id) - count;


    }

    @Override
    public Integer getTotalNumberOfDaysUsedByEmployeeID(Long id) {
        return getMaximumNoDaysForEmployeeID(id) - getTotalNumberOfDaysAvailableByEmployeeID(id);
    }

    /* baza de calcul 21 zile pe an, 2 pentru fiecare an in companie maxim 5 ani

     */
    @Override
    public Integer getMaximumNoDaysForEmployeeID(long id) {
        Employee employee = employeeDAO.findById(id);
        int count = 21;
        int years = noYears(employee);
        int i = 0;
        while (i <= 5){
            if (years - 2 > 0 ){
                count = count +2;
                years = years -2;
            }
        }


        return count;
    }

    @Override
    public boolean approveLeaveByID(Long id) {
        return dao.findById(id).getApproved();
    }


    @Override
    public boolean rejectLeaveByID(Long id) {
        return !dao.findById(id).getApproved();
    }

    public LocalDate getLocalDateFromDate(Date date){
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }

    public int noYears(Employee employee){
        LocalDate now = LocalDate.now();
        LocalDate emplDate = getLocalDateFromDate(employee.getEmploymentDate());
        return now.getYear() - emplDate.getYear();
    }

    public  LocalDate addworkingDays(Date date, int days){
        LocalDate lday = getLocalDateFromDate(date);
        if (days < 1 ){
            return lday;
        }
        LocalDate result = lday;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }


        return result;
    }

    public Date getDateFromLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public  Date getFirstDateOfYear(){
        LocalDate now = LocalDate.now(); // 2015-11-23
        LocalDate firstDay = now.with(firstDayOfYear());
        return getDateFromLocalDate(firstDay);
    }

}
