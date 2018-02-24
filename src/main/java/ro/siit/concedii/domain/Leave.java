package ro.siit.concedii.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Used to define the information needed for an Leave request.
 *
 * @author dan
 *
 */

public class Leave extends AbstractModel{
    private Date startDate;
    private int noDays;
    private LeaveType leaveType;
//lateruse
    private Boolean approved;
    private long employeeID;



    public Date endLeaveDate(){
        //calculeaza end date pe baza de zile si wk
        return null;
    };

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNoDays() {
        return noDays;
    }

    public void setNoDays(int noDays) {
        this.noDays = noDays;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leave leave = (Leave) o;
        return noDays == leave.noDays &&
                employeeID == leave.employeeID &&
                Objects.equals(startDate, leave.startDate) &&
                leaveType == leave.leaveType &&
                Objects.equals(approved, leave.approved);
    }

    @Override
    public String toString() {
        return "Leave{" + "startDate=" + startDate +", noDays=" + noDays + ", leaveType=" + leaveType + ", approved=" + approved + ", employeeID=" + employeeID + '}';
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((leaveType == null) ? 0 : leaveType.hashCode());
        result = prime * result + ((noDays == 0) ? 0 : Integer.hashCode(noDays));
        result = prime * result + ((employeeID == 0) ? 0 : Long.hashCode(employeeID));
        return result;
    }
}
