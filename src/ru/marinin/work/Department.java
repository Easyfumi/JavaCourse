package ru.marinin.work;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Employee boss;
    List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return new Employee(this.boss.name, this.boss.department);
    }
    public List<Employee> getEmployeeList() {
        return new ArrayList<>(employeeList);
    }

    public void setBoss(Employee employee) {
        if (employee.department==this) {
            this.boss = employee;
        } else {
            employee.transferTo(this);
            setBoss(employee);
        }

    }




    @Override
    public String toString() {
        if (this.boss == null) {
            return name + " department without boss";
        }
        return  name + " department the boss is " + boss.name;
    }
}