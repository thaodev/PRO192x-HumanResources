import java.time.LocalDate;

public class Employee extends Staff {
    private int hourOT;

    public Employee(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, String department, int vacationDays, int hourOT) {
        super(employeeID, employeeName, employeeAge, salaryIndex, startDate, department, vacationDays);
        this.hourOT = hourOT;
    }

    public int getHourOT() {
        return hourOT;
    }

    public void setHourOT(int hourOT) {
        this.hourOT = hourOT;
    }

    public int calculateSalary(){
        return getSalaryIndex()*3000000 + hourOT*200000;
    }

    public String toString(){
        return String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s%-8s", "employeeID", "employeeName", "employeeAge", "salaryIndex", "StartDate", "Department", "VacationDays", "HourOT");
    }

}
