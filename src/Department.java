public class Department {
    private String deptID;
    private String deptName;
    private int deptNumberOfEmployee;

    public Department(String deptID, String deptName, int deptNumberOfEmployee) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.deptNumberOfEmployee = deptNumberOfEmployee;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDepID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptNumberOfEmployee() {
        return deptNumberOfEmployee;
    }
    public void setDeptNumberOfEmployee(int deptNumberOfEmployee) {
        this.deptNumberOfEmployee = deptNumberOfEmployee;
    }



    @Override
    public String toString() {
        return "deptID: " + deptID + ", deptName: " + deptName + ", " + "Number of employees: " + deptNumberOfEmployee;
    }
}
