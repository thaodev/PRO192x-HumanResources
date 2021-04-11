import java.time.LocalDate;
import java.util.Date;

/**
 * This is an abstract class to initiate properties of a staff
 */
public abstract class Staff implements ICaculator{
    private String employeeID;
    private String employeeName;
    private int employeeAge;
    private int salaryIndex;
    private LocalDate startDate;
    private int vacationDays;

    public Staff(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, int vacationDays) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.salaryIndex = salaryIndex;
        this.startDate = startDate;
        this.vacationDays = vacationDays;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public int getSalaryIndex(){
        return salaryIndex;
    }

    public void setSalary() {
        this.salaryIndex = salaryIndex;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public abstract String toString();
}
