package cc.jku.ioAbteilungen2;

import cc.jku.ioAbteilungen.Department;

import java.util.ArrayList;
import java.util.List;

public class Department2 extends Department {
    private List<Department2> childDepartments;

    public Department2(String name) {
        super(name);
        this.childDepartments = new ArrayList<>();

    }

    public void addChildDepartment(Department2 parentDepartment) {
        this.childDepartments.add(parentDepartment);
    }

    public void printAllMembers() {

        printMembers();

        if (this.childDepartments.size() > 0) {
            for (Department2 parentDepartment : this.childDepartments) {
                System.out.println("-- child department of \"" + this.getName() + "\":");
                parentDepartment.printAllMembers();
            }
        }

    }


}
