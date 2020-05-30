package cc.jku.io.ioAbteilungen2;

import cc.jku.io.ioAbteilungen.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentWithChildDepartment extends Department {

    private List<DepartmentWithChildDepartment> childDepartments;

    public DepartmentWithChildDepartment(String name) {

        super(name);
        this.childDepartments = new ArrayList<>();

    }

    public void addChildDepartment(DepartmentWithChildDepartment childDepartment) {

        this.childDepartments.add(childDepartment);

    }

    public void printAllMembers() {

        printMembers();

        if (this.childDepartments.size() > 0) {

            for (DepartmentWithChildDepartment department : this.childDepartments) {

                System.out.println("-- child department of \"" + this.getName() + "\":");
                department.printAllMembers();

            }

        }

    }

}
