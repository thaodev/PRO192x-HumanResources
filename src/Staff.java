import java.time.LocalDate;

public abstract class Staff implements ICaculator{
    private String employeeID;
    private String employeeName;
    private int employeeAge;
    private int salaryIndex;
    private LocalDate startDate;
    private String department;
    private int vacationDays;

    public Staff(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, String department, int vacationDays) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.salaryIndex = salaryIndex;
        this.startDate = startDate;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public abstract String toString();
}
