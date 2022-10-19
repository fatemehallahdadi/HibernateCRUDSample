package com.hib.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")

//@Access(AccessType.PROPERTY)
//when you set AccessType.PROPERTY you have to move all annotations before getters, just getter, not field neither setter, otherwise they are note considered.
//PROPERTY type allows you to put some rectification or validation before set or get
// if you want to change the data before inserting to database you have to change the getters method
// allows encapsulation since the hibernate won't use the private field (we shouldn't allow that encapsulation violation to occur)

//@Access(AccessType.FIELD)
//when you set AccessType.PROPERTY you have to move all annotations before field name,

//@Column(name = "last_name" ,nullable = false , insertable = false, length = 25 , columnDefinition = "nvarchar"  )
//@Access(AccessType.PROPERTY)
public class Student {



    //----------------------------GenerationType.TABLE
    //@GeneratedValue(strategy = GenerationType.TABLE ) //create table hibernate_sequences
    //@GeneratedValue(strategy = GenerationType.TABLE ,generator = "idtable") // create table with idtable name
    //@GeneratedValue(strategy = GenerationType.TABLE ,generator = "idgen")
    //@TableGenerator(name="idgen", pkColumnName = "tables" , pkColumnValue = "student",valueColumnName = "values",table = "idgenarator-table" )

    //----------------------------GenerationType.SEQUENCE
    //@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "idgen")
    //@SequenceGenerator()


    //----------------------------GenerationType.AUTO
    //In mySQL : identity in hibernate and autoincrement in database
    //In Oracle : sequence
    //@GeneratedValue(strategy = GenerationType.AUTO )
    //@GeneratedValue


    //----------------------------GenerationType.AUTO
    //In mySQL : identity in hibernate and autoincrement in database
    //In Oracle : sequence
    //@GeneratedValue(strategy = GenerationType.AUTO )
    //-----------------------------------------------


    //----------------------------GenerationType.TABLE
     //create table hibernate_sequences
   // @GeneratedValue(strategy = GenerationType.TABLE ,generator = "idtable") // create table with idtable name
    //@GeneratedValue(strategy = GenerationType.TABLE ,generator = "idgen")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email")
    private String email;

   // @Temporal(TemporalType.TIME)
   // @Column(name = "createDate", columnDefinition = "Time")

   // @Temporal(TemporalType.DATE)
   // @Column(name = "createDate", columnDefinition = "Date")

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate", columnDefinition = "Date")
    private Date birthDate;


    @Formula("lower(datediff(curdate() , birthdate)/365)")
    private Integer age;

    public Student() {

    }

    public Student(String firstName, String lastName, String email ,Date createDate ,Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createDate = createDate;
        this.birthDate = birthDate;
       //this.fullname  =firstName + lastName;
        this.fullname = getFullname();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", age='" + age + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    @Transient
    private String fullname;

    public String getFullname() {
        return  firstName + lastName;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}