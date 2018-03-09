package ro.siit.concedii.Utils;

import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.domain.Leave;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LeaveUtils {
//    private Leave leave;
    public static final int ANNUAL = 21;
    public static final int PERYEARDAYS = 2;
    public static final int MAXYEARSTOGET = 5;
    public static final int MAXDAYOFLEAVEPERYEAR = 30;
    public static final int MARRIAGE = 5;
    public static final int BIRTH = 5;
    public static final int DEATH = 5;

    public int maxDaysPerEmopee(Employee employee) {
        Date today = new Date();
        today.setHours(0);
        int yearsInCompany = getYearsBetweenDates(employee.getEmploymentDate(), today); //nu bun
        int days;
        if (yearsInCompany > MAXYEARSTOGET) {
            days = MAXYEARSTOGET * PERYEARDAYS;
        } else {
            days = yearsInCompany * PERYEARDAYS;
        }
        int max = ANNUAL + days;

        if (max > MAXDAYOFLEAVEPERYEAR){
            return MAXDAYOFLEAVEPERYEAR;
        } else {
            return max;
        }

    }


    public Date endLeaveDate(Leave leave){
        return new Date();
    }

    public Date endLeaveDate(Date date, int noDays){
        return null;
    }

    public int noOfDaysForLeave(Leave leave){
        return 0;
    }

    private int getYearsBetweenDates(Date first, Date second) {
        Calendar firstCal = GregorianCalendar.getInstance();
        Calendar secondCal = GregorianCalendar.getInstance();

        firstCal.setTime(first);
        secondCal.setTime(second);

        secondCal.add(Calendar.DAY_OF_YEAR, 1 - firstCal.get(Calendar.DAY_OF_YEAR));

        return secondCal.get(Calendar.YEAR) - firstCal.get(Calendar.YEAR);
    }

}
