package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtils2 {

    public static void main(String[] args) {

        Configuration cfgObj = new Configuration();




        cfgObj.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        cfgObj.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/uni?useSSL=false");
        cfgObj.setProperty("hibernate.connection.username", "uniuser");
        cfgObj.setProperty("hibernate.connection.password", "uniuser");
        cfgObj.setProperty("hibernate.connection.pool_size", "5");
        cfgObj.setProperty("hibernate.show_sql", "true");
        cfgObj.setProperty("hibernate.format_sql", "true");
        //if this prop is not specified, nothing will happen, no validation, or create or drop ...
        cfgObj.setProperty("hibernate.hbm2ddl.auto", "create");
        cfgObj.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        cfgObj.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");


        cfgObj.addPackage("com.lib.model");
        //cfgObj.addClass(Student.class);

        // Creating Session Factory Object
        SessionFactory factoryObj = cfgObj.buildSessionFactory();

        // Creating Session Object
        Session sessionObj = factoryObj.openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();


        sessionObj.close();
        factoryObj.close();

        System.out.println("created session factory from inline configuration");
    }
}
