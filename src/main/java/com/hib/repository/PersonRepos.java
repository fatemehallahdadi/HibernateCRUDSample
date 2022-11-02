package com.hib.repository;

import com.hib.model.Person;

import java.util.List;

public interface PersonRepos {
    public Person createPerson(Person p);
    public void deletePerson(long id);
    public void updatePerson(long id,Person p);
    public List<Person> getPersonList();
    public Person findPerson(long id);
    public void getPerson(long id);
}
