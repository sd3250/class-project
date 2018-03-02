package ro.siit.concedii.Utils;

import ro.siit.concedii.domain.Leave;

import java.util.Date;

public abstract class BaseLeavePolicy {
    public static final int ANNUAL = 21;
    public static final int PERYEARDAYS = 2;
    public static final int AFTER10YEARSOFEMPLOYMENT = 2;
    public static final int MAXDAYOFLEAVEPERYEAR = 40;
    public static final int MARRIAGE = 5;
    public static final int BIRTH = 5;
    public static final int DEATH = 5;

    public static Date endLeaveDate(Leave leave){
        return new Date();
    }

}
