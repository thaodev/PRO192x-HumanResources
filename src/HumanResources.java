import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanResources {
    static private List<Department> dept = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static boolean isContinue;

    public static void main(String[] args) throws ParseException {
        initDept();
        initEmployee();
        initManager();

        System.out.println("Welcome to the human resource database of our company");
        Scanner in = new Scanner(System.in);
        isContinue = true;
        while (isContinue) {
            System.out.println("----------------------------------");
            System.out.println("1.Display the list of our current employees");
            System.out.println("2.Display departments in our company");
            System.out.println("3.Display departments and their employees");
            System.out.println("4.Add employee to the firm");
            System.out.println("5.Search employee by name");
            System.out.println("6.Display salary information of all employees");
            System.out.println("7.Display salary information in increasing order");
            System.out.println("8.Exit");
            System.out.println("Your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    displayStaff();
                    break;
                case 2:
                    displayDept();
                    break;
                case 3:
                    displayDeptnEmployee();
                    break;
                case 4:
                    addStaff();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    salaryDisplay();
                    break;
                case 7:
                    salaryDisplayIncreasingOrder();
                    break;
                case 8:
                    exit();
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }
    public static void initEmployee() {
        Employee employee1 = new Employee("ABC01", "Thao Nguyen", 30, 5, LocalDate.of(2020,03,12), 20, 10);
        Employee employee2 = new Employee("ABC02", "Rachel Nguyen", 20, 5, LocalDate.of(2000,02,12),  10, 10);
        Employee employee3 = new Employee("ABC06", "Phoebe Hank", 35, 5, LocalDate.of(2001,8,15), 10, 10);
        Employee employee4 = new Employee("ABC07", "Rob Miller", 50, 5, LocalDate.of(2002,7,01), 30, 20);
        dept.get(0).getStaffs().add(employee1);
        dept.get(1).getStaffs().add(employee2);
        dept.get(2).getStaffs().add(employee3);
        dept.get(2).getStaffs().add(employee4);
    }

    public static void initManager() {
        Manager manager1 = new Manager("ABC03", "Richard Pete", 50, 10,LocalDate.of(1999,03,12), 5, "Business Leader" );
        Manager manager2 = new Manager("ABC04", "Rachel Green", 60, 8,LocalDate.of(1998,04,27), 30, "Project Leader" );
        Manager manager3 = new Manager("ABC05", "Kevin Home", 45, 7,LocalDate.of(2002,12,02), 20, "Technical Leader" );
        dept.get(3).getStaffs().add(manager1);
        dept.get(4).getStaffs().add(manager2);
        dept.get(2).getStaffs().add(manager3);

    }

    public static void initDept() {
        Department dept1 = new Department("ACTN", "Accounting");
        Department dept2 = new Department("HR", "Human Resources");
        Department dept3 = new Department("PROD", "Product");
        Department dept4 = new Department("ARCH", "Architecture");
        Department dept5 = new Department("OPER", "Operation");

        dept.add(dept1);
        dept.add(dept2);
        dept.add(dept3);
        dept.add(dept4);
        dept.add(dept5);
    }
/*
this method allow user to fill out information/properties of a new staff
 */
    public static void addStaff() throws ParseException {
        System.out.println("Enter information of the new employee below: ");

        String employeeID= "";
        System.out.print("Enter employeeID: ");
        do {
            employeeID = input.nextLine();
            if (isEmployeeIdExited(employeeID)) {
                System.out.println("This employee ID was already exited. Please try a new one");
            }
        } while(isEmployeeIdExited(employeeID));

        System.out.print("Enter employee name: ");
        String employeeName = input.nextLine();

        //To check if the Age input is integer data type or not. If not, the program will force the user reenter until integer input implemented
        boolean isInvalidAge = true;
        int employeeAge = 0;
        do {
            System.out.print("Enter employee age: ");
            String ageInput = input.nextLine();
            try {
                employeeAge = Integer.parseInt(ageInput);
                if (employeeAge < 0 || employeeAge == 0) {
                    System.out.println("Employee Age needs to greater than 0");
                    isInvalidAge = true;
                } else isInvalidAge = false;
            } catch (NumberFormatException nfe) {
                isInvalidAge = true;
                System.out.println("We take only integer input for this section");
            }
        } while(isInvalidAge);

        //To check if salary index input is integer data type or not. If not, the program will force the user reenter until integer input implemented
        boolean isInvalidSalaryIndex = true;
        int salaryIndex = 0;
        do {
            System.out.print("Enter salary index: ");
            String index = input.nextLine();
            try {
                salaryIndex = Integer.parseInt(index);
                if (salaryIndex < 0 || salaryIndex == 0) {
                    System.out.println("Salary Index needs to be greater than 0");
                    isInvalidSalaryIndex = true;
                }
                else  isInvalidSalaryIndex = false;
            } catch (NumberFormatException nfe) {
                isInvalidSalaryIndex = true;
                System.out.println("We take only integer input for this section");
            }
        } while(isInvalidSalaryIndex);

        //This to add date input
        boolean isDateFormatInvalid = true;
        LocalDate startDate = null;
        do {
            System.out.println("Enter Start Date (format YYYY-MM-DD): ");
            String date = input.nextLine();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                startDate = LocalDate.parse(date, df);
                isDateFormatInvalid = false;

            } catch (Exception e) {
                System.out.println("Please enter the correct date format");
                isDateFormatInvalid = true;
            }
        } while (isDateFormatInvalid);
        //input.nextLine();

        boolean isInvalidVacationDay = true;
        int vacationDays = 0;
        do {
            System.out.print("Enter vacation days: ");
            String vacation = input.nextLine();
            try {
                vacationDays = Integer.parseInt(vacation);
                if (vacationDays < 0) {
                    System.out.println("Vacation Days can't be lesser than 0");
                    isInvalidVacationDay = true;
                }
                else  isInvalidVacationDay = false;
            } catch (NumberFormatException nfe) {
                isInvalidVacationDay = true;
                System.out.println("We take only integer input for this section");
            }
        } while(isInvalidVacationDay);



        /*This is to check the role of the staff
        * input only takes value of 0 or 1. Any other numbers or letter is not acceptable and the program will force user to re-input*/
        Staff staff = null;
        boolean isRoleLoopContinued = true;
        int staffRole = 0;
        do {
            System.out.print("Is the new staff role as employee or manager? Enter 0 if employee and 1 if manager: ");
            String role = input.nextLine();
            //input.nextLine();
            try {
                staffRole = Integer.parseInt(role);
                if (staffRole == 0) {
                    int hourOT = 0;
                    staff = new Employee(employeeID, employeeName, employeeAge, salaryIndex, startDate, vacationDays, hourOT);
                    isRoleLoopContinued = false;
                } else if (staffRole == 1) {
                    System.out.println("Enter title of the manager: ");
                    String title = input.nextLine();
                    staff = new Manager(employeeID, employeeName, employeeAge, salaryIndex, startDate, vacationDays, title);
                    isRoleLoopContinued = false;
                } else {
                    System.out.println("We only take value of 0 or 1. Please try again");
                    isRoleLoopContinued = true;
                }
            } catch (NumberFormatException nfe) {
                isRoleLoopContinued = true;
                System.out.println("We take only integer input for this section");
            }
        } while(isRoleLoopContinued);

        //This to make sure the user inputs the valid department ID that exits on the system, if not, the user will be forced to reentered again.
        boolean isInvalidDeptId = true;
        do {
            System.out.println("Enter department ID: ");
            displayDept();
            String departmentID = input.next();
            for (int i = 0; i < dept.size(); i++) {
                if (dept.get(i).getDeptID().equalsIgnoreCase(departmentID)) {
                        dept.get(i).getStaffs().add(staff);
                    isInvalidDeptId = false;
                        System.out.println(("A new staff has been added"));
                }
            }
            if(isInvalidDeptId) {
                    System.out.println("There is no such department ID. Please try again");
                }
        }  while (isInvalidDeptId) ;

    }
    //This method to check if the new employee ID for a new staff already  existed
    public static boolean isEmployeeIdExited(String employeeID) {
        for (Department dep : dept) {
            for (Staff staff : dep.getStaffs()) {
                if (employeeID.toUpperCase().equals(staff.getEmployeeID())) {
                    return true;
                }
            }
        }
        return false;
    }

   /* public static boolean isDeptIdMatched(String departmentID) {
        for (int i = 0; i < dept.size(); i++) {
            if (dept.get(i).getDeptID().equalsIgnoreCase(departmentID)) {
                return true;
            }
        }
        return false;
    }*/

    /*This method to display all of staffs*/
    public static void displayStaff() {
        System.out.println(String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s", "EmployeeID", "EmployeeName", "EmployeeAge", "SalaryIndex", "StartDate", "Department", "VacationDays"));
        for (Department dep : dept) {
            for (Staff staff : dep.getStaffs()) {
                System.out.println(String.format("%-13s%-15s%-13s%-12s%-15s%-20s%-12s", staff.getEmployeeID(), staff.getEmployeeName(), staff.getEmployeeAge(), staff.getSalaryIndex(), staff.getStartDate(), dep.getDeptName(), staff.getVacationDays()));
            }
        }

    }

    public static void displayDept() {
        System.out.println(String.format("%-13s%-20s%-20s", "DeptID", "Department Name", "NumberOfEmployee"));
        for (int i = 0; i < dept.size(); i++) {
            Department d = dept.get(i);
            System.out.println(String.format("%-13s%-20s%-20s", d.getDeptID(), d.getDeptName(), d.getDeptNumberOfEmployee()));
        }
    }

    public static void displayDeptnEmployee() {
        System.out.println(String.format("%-13s%-20s%-20s", "DeptID", "Department Name", "Employee Name"));
        int i = 1;
        for (Department d : dept) {
            for (Staff staff : d.getStaffs()) {
                System.out.println(String.format("%-13s%-20s%-20s", d.getDeptID(), d.getDeptName(), staff.getEmployeeName()));
            }
        }
    }

    public static void search() {
        ArrayList<Staff> staffFound = new ArrayList<>();
        System.out.println("Enter Staff Name to search: ");
        String searchKey = input.next();
        boolean isFound = false;
        System.out.println(String.format("%-13s%-15s%-13s%-15s%-15s%-20s%-12s", "Employee ID", "Employee Name", "Employee Age", "Salary Index", "Start Date", "Department", "Vacation Days"));
        for (Department d : dept) {
            for (Staff staff : d.getStaffs()) {
                if (staff.getEmployeeName().toLowerCase().contains(searchKey.toLowerCase())) {
                    //staffFound.add(staff);
                    isFound = true;
                    System.out.println(String.format("%-13s%-15s%-13s%-15s%-15s%-20s%-12s", staff.getEmployeeID(), staff.getEmployeeName(), staff.getEmployeeAge(), staff.getSalaryIndex(), staff.getStartDate(), d.getDeptName(), staff.getVacationDays()));

                }
            }
        }

        if (!isFound) {
            System.out.println("No staff was found");
        }
    }

    public static void salaryDisplay() {
        System.out.println(String.format("%-15s%-20s%-15s", "Employee ID", "Employee Name", "Salary"));
        for (Department dep : dept) {
            for (Staff staff : dep.getStaffs()) {
                staff.calculateSalary();
                System.out.println(String.format("%-15s%-20s%-15s", staff.getEmployeeID(), staff.getEmployeeName(), staff.calculateSalary()));

            }
        }

    }
    public static void salaryDisplayIncreasingOrder() {
        System.out.println(String.format("%-15s%-20s%-15s", "Employee ID", "Employee Name", "Salary"));
        List<Staff> staffs = new ArrayList<>();
        for (Department dep : dept) {
            for (Staff staff : dep.getStaffs()) {
                staffs.add(staff);
            }
        }

        Staff tempt;
        for (int i = 0; i < staffs.size() - 1; i++)
            for (int j = i + 1; j < staffs.size() ; j++) {
                if (staffs.get(i).calculateSalary() > staffs.get(j).calculateSalary()) {
                    tempt = staffs.get(i);
                    staffs.set(i, staffs.get(j));
                    staffs.set(j, tempt);
                }
            }
        for (Staff staff : staffs) {
            System.out.println(String.format("%-15s%-20s%-15s", staff.getEmployeeID(),staff.getEmployeeName(), staff.calculateSalary()));
        }

    }

    public static void exit() {
        System.out.println("You choose to exist the program. Have a good day!");
        isContinue = false;
    }
        /*
         * for (Department dep : dept) {
         *             staffs.addAll(dep.getStaffs());
         *         }
         */









}
