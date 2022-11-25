package com.domainmodule.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "login_id",nullable = false,unique = true)
    private String login_id;

    @Column(name = "password",nullable = false)
    private String password;

    public Admin() {
    }

    public Admin(int admin_id, String name, String login_id, String password) {
        this.admin_id = admin_id;
        this.name = name;
        this.login_id = login_id;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
