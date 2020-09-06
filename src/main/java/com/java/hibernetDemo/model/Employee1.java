package com.java.hibernetDemo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee",uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Employee1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",length = 20,nullable = false,unique = true)
    private int id;
    @Column(name = "NAME",length = 40,nullable = false)
    private String name;
    @Column(name = "ROLE",length = 20,nullable = false)
    private String role;
    @Column(name = "InsertTime",nullable = true)
    private Date insertTime;

    public Employee1() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}
