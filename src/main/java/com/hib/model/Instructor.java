package com.hib.model;

import javax.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id" )
    private InstructorDetail instructorDetail;

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public Instructor(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Instructor() {

    }



    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    //
}
//-------------------------Primary key :
//identify a unique row in table
//-------------------------Foreign key :
//1- link tables together
//2- a field in one table that refers a primary key in another table
//-------------------------Cascade:
//you can cascade operations, you can have same operation to the related entities.
//for example if we want to save the 'Instructor', then it'll also cascade that operation and apply the same operation to 'InstructorDetail'
//if we delete the instructor, we should also delete the InstructorDetail
//-----note that cascade delete depends on use case
///Cascade Types:
//Persist/Save
//Remove
//Refresh
//Detached
//All


//-------------------------FetchType :
//when we fetch/retrieve data, should we retrieve everything,
//EAGER : will retrieve everything
//Lazy  : will retrieve on request


//-------------------------Uni-Directional :
//you have the instructor and then you actually have the instructorDetail,
//you start with instructor, you load the instructor object and then from there you can access the instructorDetail
//its one way relationship


//-------------------------Bi-Directional :
//we have the instructor, we can access the instructorDetail, and also we can go the other way
//we can load the instructorDetail and then we can get instructor

//------------------------Entity LifeCycle
//1---Detach : Its not associated with a hibernate session
//2---Merge  : If instance id detached from session, then merge will reattach to session
//3---Persist: Transition new instance to managed state, Next flush/ commit will save in db.
//4---Remove : Transitions managed entity to be removed, Next flush/commit will delete from db.
//5---Refresh: Reload/Sync object with data from db. Prevent stale data.