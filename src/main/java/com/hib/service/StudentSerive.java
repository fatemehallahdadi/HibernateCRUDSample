package com.hib.service;


import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentSerive {

    static SessionFactory sessionFactory =  SessionFactoryProvider.getSessionFactory() ;

    public static void main(String[] args) throws Exception {

        //checkConnection();
        createStudent();
    }

    public static void createStudent() throws Exception {


        Session s = sessionFactory.openSession();
        String dateInString1 = "22/08/1987";
        String dateInString2 = "22/08/1987";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formatter.parse(dateInString1);
        Date date2 = formatter.parse(dateInString2);

        Student std1 =  new Student("مونا", "jahromi", "m.j@gmail.com", new Date() , date1);
        Student std2 =  new Student("مونا", "jahromi", "m.j@gmail.com" , new Date() ,date2);
    //    Person prs =  new Person();
        s.beginTransaction();
        s.save(std1);
        s.save(std2);

     //   s.save(prs);

        s.getTransaction().commit();
        s.refresh(std1);
        s.refresh(std2);
     //   s.refresh(prs);
       // System.out.println("student 1: " + s.get(Student.class, 1) );
      //  System.out.println("Person: " + prs);
        System.out.println("Student 1: " + std1);
        System.out.println("Student 2: " + std2);

        s.close();


    }


    public static void checkConnection() {

        SessionFactory sessionFactory =  SessionFactoryProvider.getSessionFactory() ;

        Session s = sessionFactory.openSession();
        s.close();

    }





}
