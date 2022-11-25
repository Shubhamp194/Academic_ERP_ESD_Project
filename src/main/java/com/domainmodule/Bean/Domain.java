package com.domainmodule.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name ="domain")
public class Domain {
    @Id
    @Column(name ="domain_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int domain_id;

    @Column(name="program",nullable = false,unique = true)
    private String program;

    @Column(name="batch",nullable = false,unique = true)
    private String batch;

    @Column(name="capacity",nullable = false,unique = false)
    private int capacity;

    @Column(name="qualification",nullable = true,unique = false)
    private int qualification;

    @OneToMany(mappedBy = "s_domain_id", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Student> studentList;

    public Domain() {
    }

    public Domain(int domain_id, String program, String batch, int capacity, int qualification,List<Student> studentList ) {
        this.domain_id = domain_id;
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
        this.qualification = qualification;
        this.studentList = studentList;
    }

    public int getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(int domain_id) {
        this.domain_id = domain_id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
