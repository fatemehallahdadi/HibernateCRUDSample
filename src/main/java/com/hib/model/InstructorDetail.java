package com.hib.model;


import javax.persistence.*;

@Entity
@Table(name= "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id ;

    @Column
    private String siteUrl;

    @Column
    private String githubUrl;

    public InstructorDetail(String siteUrl, String githubUrl) {
        this.siteUrl = siteUrl;
        this.githubUrl = githubUrl;
    }

    public InstructorDetail() {

    }


    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @OneToOne(mappedBy = "instructorDetail")
    private Instructor instructor;


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", siteUrl='" + siteUrl + '\'' +
                ", githubUrl='" + githubUrl + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}


////--------to create bi-directional
//1- add new field to reference Instructor
//2- add getter and setter for Instructor
//3- add @oneToOne annotation

