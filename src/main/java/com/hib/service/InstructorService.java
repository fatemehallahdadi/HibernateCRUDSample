package com.hib.service;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Instructor;
import com.hib.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InstructorService {


    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public static void main(String[] args) throws Exception {

          createInstructor();
        //  deleteInstructor();
        //  System.out.println(getInstructorDetail(1l));

    }


    private static void createInstructor() {

        Instructor instructor = new Instructor("Hamid", "Hamidi", "Hamid@gamil.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://hamid.org", "http://hamid.git.com");

        instructor.setInstructorDetail(instructorDetail);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //return type of persist is void while return type of save is Serializable Object
        session.persist(instructor);
        session.save(instructor);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }


    private static void deleteInstructor() {


        Session session = sessionFactory.openSession();
        session.beginTransaction();


        Instructor instructor = (Instructor) session.get(Instructor.class, 1l);
        session.delete(instructor);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }

    private static InstructorDetail getInstructorDetail(Long id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();


        InstructorDetail InstructorDetail = (InstructorDetail) session.get(InstructorDetail.class, id);

        session.close();
        sessionFactory.close();

        return InstructorDetail;
    }


}
