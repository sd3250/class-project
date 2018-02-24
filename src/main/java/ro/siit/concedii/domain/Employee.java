package ro.siit.concedii.domain;

import java.util.Date;

/**
 * used to define the information needed for an employee.
 *
 * @author (original) sebi
 * @updated dan
 * NU MAI ADAUG SI LOGICA DE ZILE DE CONCEDIU IN PLUS NEGOCIATE LA ANGAJARE
 */
public class Employee extends AbstractModel {
    private String firstName;
    private String lastName;

    private Date birthDate;

    private Gender gender;

    private Date employmentDate;

    private String jobTitle;

    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }
//adaugat pentru a testa mai usor
    public Employee(String firstName, String lastName, Date birthDate, Gender gender, Date employmentDate, String jobTitle, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.employmentDate = employmentDate;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", gender="
                + gender + ", employmentDate=" + employmentDate + ", jobTitle=" + jobTitle + ", salary=" + salary + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        result = prime * result + ((employmentDate == null) ? 0 : employmentDate.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((salary == 0) ? 0 : Double.hashCode(salary));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (birthDate == null) {
            if (other.birthDate != null)
                return false;
        } else if (!birthDate.equals(other.birthDate))
            return false;
        if (employmentDate == null) {
            if (other.employmentDate != null)
                return false;
        } else if (!employmentDate.equals(other.employmentDate))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (gender != other.gender)
            return false;
        if (jobTitle == null) {
            if (other.jobTitle != null)
                return false;
        } else if (!jobTitle.equals(other.jobTitle))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return (salary == other.salary);
    }

}
