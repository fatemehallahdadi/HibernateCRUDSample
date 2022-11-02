package com.hib.service;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.*;
import com.hib.repository.implemRepos.PersonImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PersonService {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public static void main(String[] args) {
        //create 3 person
        //create first person
        Map<RelationType, String> refere1 = new HashMap<>();
        refere1.put(RelationType.MOTHER, "monireh");
        refere1.put(RelationType.FATHER, "amin");
        refere1.put(RelationType.SPOUSE, "saeed");

        Address address1 = new Address("iran", "tehran", "tehranpars", "112");
        Person p1 = new Person("0020551541", "fatemeh", "allahdadi", Gender.FEMALE, MartialStatus.MARRIED, refere1);
        p1.setAddress(address1);

        //create second person
        Map<RelationType, String> refere2 = new HashMap<>();
        refere2.put(RelationType.MOTHER, "zohre");
        refere2.put(RelationType.FATHER, "majid");
        refere2.put(RelationType.SPOUSE, "mehdi");

        Address address2 = new Address("alman", "berlin", "sadeghie", "873");
        Person p2 = new Person("0020551541", "fatemeh", "allahdadi", Gender.FEMALE, MartialStatus.MARRIED, refere2);
        p2.setAddress(address2);

        //create third person
        Map<RelationType, String> refere3 = new HashMap<>();
        refere3.put(RelationType.MOTHER, "zahra");
        refere3.put(RelationType.FATHER, "mahmod");
        refere3.put(RelationType.SPOUSE, "javid");

        Address address3 = new Address("amrika", "sanfransisco", "miane", "979");
        Person p3 = new Person("0020551541", "fatemeh", "allahdadi", Gender.FEMALE, MartialStatus.SINGLE, refere3);
        p3.setAddress(address3);



        //test delete method
//        PersonImp personImp=new PersonImp();
//        personImp.deletePerson(1l);


        //test update method
//        p1.setfName("raha");
//        personImp.updatePerson(2,p1);


        //test find method
//        personImp.findPerson(2);
    }



}
