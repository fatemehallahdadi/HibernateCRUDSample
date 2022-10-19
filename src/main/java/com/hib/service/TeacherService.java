package com.hib.service;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Address;
import com.hib.model.Teacher;
import com.hib.model.TeacherStatus;
import com.hib.model.Workshop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class TeacherService {

    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public static void main(String[] args) throws Exception {

        createTeacher();
       // System.out.println(getTeacher(1l));

    }

    private static Teacher getTeacher(long id) {
       Session s = sessionFactory.openSession();
       s.beginTransaction();

       return s.get(Teacher.class,id );
    }


    private static void createTeacher() {
        Session s = sessionFactory.openSession();

        Teacher teacher = new Teacher("0001");
        teacher.setStatus(TeacherStatus.ACTIVE);

        //-----Creating address
        Address adr = new Address("Iran", "Terna", "Modares", 11);
        teacher.setAddress(adr);

        //-----Creating relations
        Map<PersonRelationType, String> relations = new HashMap<>();
        relations.put(PersonRelationType.MOTHER, "hossein");
        relations.put(PersonRelationType.FATHER, "ameneh");
        teacher.setRelation(relations);

        //-----Creating referee
        List<String> referee = new ArrayList<>();
        referee.add("dr1");
        referee.add("dr2");
        teacher.setReferee(referee);

        //----------------Creating workshops
        List<Workshop> ws = Arrays.asList(new Workshop("optimization workshop", true),
                new Workshop("computing1", false),
                new Workshop("computing2", true));

        teacher.setWorkshop(ws);

        //----------------Creating sorted workshops
        Set<Workshop> wss = teacher.getWorkshopSorted();
        wss.add(new Workshop("optimization workshop", true));
        wss.add(new Workshop("computing", false));
        wss.add(new Workshop("analise", true));

        //------------------------------

        s.beginTransaction();
        s.save(teacher);

        s.getTransaction().commit();

        s.close();
        sessionFactory.close();

    }


}
