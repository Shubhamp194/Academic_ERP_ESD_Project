package com.domainmodule.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(name = "first_name",nullable = false)
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "title")
    private String title;

    @Column(name = "photograph_path")
    private String photograph_path;

    @ManyToOne
    @JoinColumn(name = "e_department")
    private Department e_department;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String email, String title, String photograph_path, Department e_department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        this.photograph_path = photograph_path;
        this.e_department = e_department;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public Department getE_department() {
        return e_department;
    }

    public void setE_department(Department e_department) {
        this.e_department = e_department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", photograph_path='" + photograph_path + '\'' +
                ", e_department=" + e_department +
                '}';
    }
}
