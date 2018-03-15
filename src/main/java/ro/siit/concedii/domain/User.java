package ro.siit.concedii.domain;

import java.util.Objects;

public class User extends AbstractModel{
    private String userName;

    private String password;

    private long employeeId;

    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getEmployeeId() == user.getEmployeeId() &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getUserName(), getPassword(), getEmployeeId());
    }
}
