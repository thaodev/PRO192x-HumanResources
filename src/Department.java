import java.util.ArrayList;
import java.util.List;

/**
 * this is department class with 2 properties deptID and dept name
 */
public class Department {
    private List<Staff> staffs = new ArrayList<>();
    private String deptID;
    private String deptName;

    public Department(String deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;

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

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptNumberOfEmployee() {
        return staffs.size();
    }

    @Override
    public String toString() {
        return "deptID: " + deptID + ", deptName: " + deptName + ", " + "Number of employees: " + staffs.size();
    }
}
