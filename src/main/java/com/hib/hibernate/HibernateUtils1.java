package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//1 - first way : Build the SessionFactory with hiberante.cfg.xml
public class HibernateUtils1 {

    public static void main(String[] args) {

        Configuration cfgObj = new Configuration();

        //1 :
        cfgObj.configure();
        //2:
       // cfgObj.configure("hibernate.cfg.xml");


        // Creating Session Factory Object
        SessionFactory factoryObj = cfgObj.buildSessionFactory();

        // Creating Session Object
        Session sessionObj = factoryObj.openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();

       // sessionObj.getTransaction().

        sessionObj.close();
        factoryObj.close();

        System.out.println("Employee Data Successfully Saved In Database!");
    }
}
