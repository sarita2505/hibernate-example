package com.java.oneToone.TestMain;

import com.java.oneToone.model.Customer;
import com.java.oneToone.model.Txn;
import com.java.oneToone.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Txn txn = new Txn();
        txn.setDate(new Date());
        txn.setTotal(100);

        Customer cust = new Customer();
        cust.setAddress("Bangalore, India");
        cust.setEmail("pankaj@gmail.com");
        cust.setName("Pankaj Kumar");

        txn.setCustomer(cust);

        cust.setTxn(txn);

        try {
            Session session= HibernateUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(txn);
            session.getTransaction().commit();
            System.out.println("txn id is"+txn.getId());
        }catch (Exception e){
            System.out.println("exception :"+ e);
            throw new RuntimeException(e);
        }
    }
}
