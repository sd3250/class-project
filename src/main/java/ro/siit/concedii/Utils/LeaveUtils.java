package ro.siit.concedii.Utils;

import ro.siit.concedii.domain.Leave;

import java.util.Date;

public class LeaveUtils {
    private Leave leave;
    public static final int ANNUAL = 21;
    public static final int PERYEARDAYS = 2;
    public static final int AFTER10YEARSOFEMPLOYMENT = 2;
    public static final int MAXDAYOFLEAVEPERYEAR = 40;
    public static final int MARRIAGE = 5;
    public static final int BIRTH = 5;
    public static final int DEATH = 5;

    public Date endLeaveDate(Leave leave){
        return new Date();
    }

    //just for testing
    public LeaveUtils(Leave leave) {
        this.leave = leave;
    }

    public Date endLeaveDate(Date date, int noDays){
        return null;
    }

    public int noOfDaysForLeave(Leave leave){
        return 0;
    }

}
