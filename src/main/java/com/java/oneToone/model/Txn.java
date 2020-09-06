package com.java.oneToone.model;

import com.java.oneToone.model.Customer;

import java.util.Date;

public class Txn {
    private long id;
    private Date date;
    private double total;
    private Customer customer;

    public Txn() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Txn{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }
}
