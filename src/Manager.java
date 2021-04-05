import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Manager extends Staff {
    private String title;

    public Manager(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, String department, int vacationDays, String title) {
        super(employeeID, employeeName, employeeAge, salaryIndex, startDate, department, vacationDays);
        this.title = title;
    }

    public int calculateSalary() {
        int[] basicManagerSalary = new int[3];
        basicManagerSalary[1] = 8000000;
        basicManagerSalary[2] = 5000000;
        basicManagerSalary[3] = 6000000;
        if (title.equals("Business Leader")) {
            return getSalaryIndex() * 5000000 + basicManagerSalary[0];
        } else if (title.equals("Project Leader")) {
            return getSalaryIndex() * 5000000 + basicManagerSalary[1];
        } else {
            return getSalaryIndex() * 5000000 + basicManagerSalary[2];
        }
    }

    public String toString() {
        return String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s%-8s", "employeeID", "employeeName", "employeeAge", "salaryIndex", "StartDate", "Department", "VacationDays", "Title");
    }
}
