package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Person;
import com.hib.repository.PersonRepos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonImp implements PersonRepos {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    @Override
    public Person createPerson(Person p) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        session.save(p);
        tr.commit();
        session.close();
        return p;
    }

    @Override
    public void deletePerson(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Person p=session.get(Person.class,id);
        session.delete(p);
        tr.commit();
        session.close();

    }

    @Override
    public void updatePerson(long id, Person p) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Person p1=session.get(Person.class,id);

        p1.setfName(p.getfName());
        p1.setlName(p.getlName());
        p1.setAddress(p.getAddress());
        p1.setGender(p.getGender());
        p1.setNationalCode(p.getNationalCode());
        p1.setMartialStatus(p.getMartialStatus());

        session.save(p1);
        tr.commit();
        session.close();
    }


    //retrieve
    @Override
    public List<Person> getPersonList() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Person> q = session.createQuery("from Person ");
        if (q.list() != null) {
            return q.list();
        }

        tr.commit();
        session.close();
        return null;
    }
    @Override
    public void getPerson(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Person p=session.get(Person.class,id);
        session.save(p);
        tr.commit();
        session.close();
    }

    @Override
    public Person findPerson(long id){
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Person p=session.get(Person.class,id);
        session.save(p);
        tr.commit();
        session.close();

        return p;
    }


}
