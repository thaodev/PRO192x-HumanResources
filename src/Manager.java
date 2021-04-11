import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * this is a manager class extends of staff class with added Title
 */
public class Manager extends Staff {
    private String title;

    public Manager(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, int vacationDays, String title) {
        super(employeeID, employeeName, employeeAge, salaryIndex, startDate, vacationDays);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*This is salary calculation for manager*/
    public int calculateSalary() {
        int[] basicManagerSalary = new int[3];
        basicManagerSalary[0] = 8000000;
        basicManagerSalary[1] = 5000000;
        basicManagerSalary[2] = 6000000;
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
