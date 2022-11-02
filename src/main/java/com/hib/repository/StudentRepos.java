package com.hib.repository;

public interface StudentRepos {
    public Student createStudent(Student s);
    public void deleteStudent(long id);
    public void updateStudent(long id,Student s);
    public void retrieveStudent(long id);
}
