package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.repository.StudentRepos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentImp implements StudentRepos {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    @Override
    public Student createStudent(Student s) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        session.save(s);
        tr.commit();
        session.close();
        return s;
    }

    @Override
    public void deleteStudent(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Student s=session.get(Student.class,id);
        session.delete(s);
        tr.commit();
        session.close();

    }

    @Override
    public void updateStudent(long id, Student s) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Student s1=session.get(Student.class,id);
        s1=s;
        session.save(s1);
        tr.commit();
        session.close();
    }

    @Override
    public void retrieveStudent(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Student s=session.get(Student.class,id);
        session.save(s);
        tr.commit();
        session.close();
    }

}
