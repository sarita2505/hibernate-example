package com.java.hibernetDemo.testMain;

import com.java.hibernetDemo.model.Employee1;
import com.java.hibernetDemo.utils.HibernetUtils;
import org.hibernate.Session;

import java.util.Date;

public class TestJava {
    public static void main(String[] args) {
        Employee1 emp = new Employee1();
        emp.setId(5);
        emp.setName("Liza");
        emp.setRole("Manager");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernetUtils.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
       // session.save(emp);

       session.update(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());
        HibernetUtils.getSessionFactory().close();
    }
}
