import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanResources {
    static List<Staff> staffs = new ArrayList<>();
    static List<Department> dept = new ArrayList<>();

    public static void main(String[] args) throws ParseException {
        initEmployee();
        initManager();
        initDept();

        System.out.println("Welcome to the human resource database of our company");
        Scanner in = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("----------------------------------");
            System.out.println("1.Display the list of our current employees");
            System.out.println("2.Display departments in our company");
            System.out.println("3.Display employees and their departments");
            System.out.println("4.Add employee to the firm");
            System.out.println("5.Search employee by name");
            System.out.println("6.Display salary information of all employees");
            System.out.println("7.Display salary information in increasing order");
            System.out.println("Your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    HumanResources.displayStaff();
                    break;
                case 2:
                    HumanResources.displayDept();
                    break;
                case 3:
                    break;
                case 4:
                    HumanResources.addStaff();
                    break;
                case 5:
                    HumanResources.search();
                    break;


            }
        }
    }
    public static void initEmployee() {
        Employee employee1 = new Employee("ABC01", "Thao Nguyen", 30, 5, LocalDate.of(2020,03,12), "Accounting", 20, 10);
        Employee employee2 = new Employee("ABC02", "Rachel Nguyen", 20, 5, LocalDate.of(2000,02,12), "Product", 10, 10);
        Employee employee3 = new Employee("ABC06", "Phoebe Hank", 35, 5, LocalDate.of(2001,8,15), "Human Resources", 10, 10);
        Employee employee4 = new Employee("ABC07", "Rob Miller", 50, 5, LocalDate.of(2002,7,01), "Architecture", 30, 20);
        staffs.add(employee1);
        staffs.add(employee2);
        staffs.add(employee3);
        staffs.add(employee4);
    }

    public static void initManager() {
        Manager manager1 = new Manager("ABC03", "Richard Pete", 50, 10,LocalDate.of(1999,03,12),"Operation", 5, "Business Leader" );
        Manager manager2 = new Manager("ABC04", "Rachel Green", 60, 8,LocalDate.of(1998,04,27),"Product", 30, "Project Leader" );
        Manager manager3 = new Manager("ABC05", "Kevin Home", 45, 7,LocalDate.of(2002,12,02),"Architecture", 20, "Technical Leader" );
        staffs.add(manager1);
        staffs.add(manager2);
        staffs.add(manager3);
    }

    public static void initDept() {
        Department dept1 = new Department("ACTN", "Accounting", 1);
        Department dept2 = new Department("HR", "Human Resources", 1);
        Department dept3 = new Department("PROD", "Product", 2);
        Department dept4 = new Department("ARCH", "Architecture", 2);
        Department dept5 = new Department("OPER", "Operation", 1);

        dept.add(dept1);
        dept.add(dept2);
        dept.add(dept3);
        dept.add(dept4);
        dept.add(dept5);
    }

    public static void addStaff() throws ParseException {
        System.out.println("Enter information of the new employee below: ");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employeeID: ");
        String employeeID = input.nextLine();

        System.out.print("Enter employee name: ");
        String employeeName = input.nextLine();

        System.out.print("Enter employee age: ");
        int employeeAge = input.nextInt();

        System.out.print("Enter salary index: ");
        int salaryIndex = input.nextInt();

        System.out.print("Enter the Start Date (year/month/date): ");
        String date = input.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate startDate = LocalDate.parse(date, formatter);

        System.out.print("Enter department: ");
        String department = input.nextLine();

        System.out.print("Enter vacation days: ");
        int vacationDays = input.nextInt();

        System.out.print("Is the new staff role as employee or manager? Enter 0 if employee and 1 if manager: ");
        int staffRole = input.nextInt();
        if (staffRole == 0) {
            int hourOT = 0;
            addEmployee(employeeID, employeeName, employeeAge, salaryIndex, startDate, department, vacationDays, hourOT);
            System.out.println("A new employee has been added");
        }
        else if (staffRole == 1) {
            System.out.println("Enter title of the manager: ");
            String title = input.nextLine();
            addManager(employeeID, employeeName, employeeAge, salaryIndex, startDate, department, vacationDays, title);
            System.out.println(("A new manager has been added"));
        }
        else {
            System.out.println("We only take value of 0 or 1. Please try again");
        }

    }

    public static void addEmployee(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, String department, int vacationDays, int hourOT) {
        Employee newEmployee = new Employee(employeeID, employeeName, employeeAge, salaryIndex, startDate, department, vacationDays, hourOT);
        staffs.add(newEmployee);
    }

    public static void addManager(String employeeID, String employeeName, int employeeAge, int salaryIndex, LocalDate startDate, String department, int vacationDays, String title) {
        Manager newManager = new Manager(employeeID, employeeName, employeeAge, salaryIndex, startDate, department, vacationDays, title);
        staffs.add(newManager);
    }

    public static void displayStaff() {
        System.out.println(String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s", "EmployeeID", "EmployeeName", "EmployeeAge", "SalaryIndex", "StartDate", "Department", "VacationDays"));
        for (Staff staff : staffs) {
            System.out.println(String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s", staff.getEmployeeID(), staff.getEmployeeName(), staff.getEmployeeAge(), staff.getSalaryIndex(), staff.getStartDate(), staff.getDepartment(), staff.getVacationDays()));
        }

    }

    public static void displayDept() {
        System.out.println(String.format("%-13s%-20s%-20s", "DeptID", "Department Name", "NumberOfEmployee"));
        for (Department dept : dept) {
            System.out.println(String.format("%-13s%-20s%-20s", dept.getDeptID(), dept.getDeptName(), dept.getDeptNumberOfEmployee()));
        }
    }

    public static void search() {
        ArrayList<Staff> staffFound = new ArrayList<>();
        System.out.println("Enter Staff Name to search: ");
        Scanner src = new Scanner(System.in);
        String searchKey = src.next();

        for (Staff staffSearch : staffs) {
            if (staffSearch.getEmployeeName().toLowerCase().contains(searchKey)) {
                staffFound.add(staffSearch);
            }
        }

        if (staffFound.isEmpty()) {
            System.out.println("No staff was found");
        } else {
            System.out.println(String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s", "EmployeeID", "EmployeeName", "EmployeeAge", "SalaryIndex", "StartDate", "Department", "VacationDays"));
            for (Staff staffSearch : staffFound) {
                System.out.println(String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s", staffSearch.getEmployeeID(), staffSearch.getEmployeeName(), staffSearch.getEmployeeAge(), staffSearch.getSalaryIndex(), staffSearch.getStartDate(), staffSearch.getDepartment(), staffSearch.getVacationDays()));
            }
        }
    }




}
