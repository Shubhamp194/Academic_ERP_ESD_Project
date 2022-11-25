package com.domainmodule.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int department_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "e_department",fetch = FetchType.EAGER)
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(String name, int capacity, List<Employee> employeeList) {
        this.name = name;
        this.capacity = capacity;
        this.employeeList = employeeList;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", employeeList=" + employeeList +
                '}';
    }
}
