package ru.marinin.work;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    Department department;
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        this.department.employeeList.add(this);
    }

    public void quit() {
        if (this.department.boss==this) {
            this.department.boss=null;
        }
        this.department.employeeList.remove(this);
        this.department=null;
    }

    public void transferTo(Department department) {
        quit();
        this.department = department;
        this.department.employeeList.add(this);
    }

    @Override
    public String toString() {
        if (this.department==null) {
            return  name + " without department";
        }
        if (this!=department.boss) {
            return name + " work in " + department;
        } else {
            return name + " is the boss of " + department.getName() + " department";
        }
    }
}
