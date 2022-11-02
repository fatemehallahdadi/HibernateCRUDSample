package com.hib.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="T_Person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prs_id")
    private Long id ;

    @Column(name="prs_nationalCode")
    private String nationalCode;

    @Column(name="prs_fname")
    private String fName;

    @Column(name="prs_lname")
    private String lName;

    @Column(name="Gender")
    @Enumerated(EnumType.STRING)
    private Gender gender=Gender.UNKNOWN;

    @Column(name="martial_status")
    @Enumerated(EnumType.STRING)
    private MartialStatus martialStatus=MartialStatus.SINGLE;

    @Embedded
    private Address address;

    @ElementCollection
    //@MapKeyColumn(name = "Person_ref_num")
    @CollectionTable(name="PersonRelation",joinColumns = @JoinColumn(name="Person_id"))
    private Map<RelationType, String> personRelation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MartialStatus getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(MartialStatus martialStatus) {
        this.martialStatus = martialStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person( String nationalCode,String fName, String lName, Gender gender, MartialStatus martialStatus,  Map<RelationType, String> personRelation) {

        this.nationalCode = nationalCode;
        this.gender = gender;
        this.martialStatus = martialStatus;
        this.personRelation = personRelation;
        this.fName = fName;
        this.lName = lName;
    }

    public Person() {
    }
}


