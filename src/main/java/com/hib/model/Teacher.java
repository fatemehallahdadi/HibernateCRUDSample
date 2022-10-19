package com.hib.model;


import com.hib.service.PersonRelationType;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Entity
//In This Class we have complete example of Value Types In Hibernate
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //----------------------Basic Value
    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    @Column
    private TeacherStatus status; //  Enum Type Field

    //----------------------Embedded Value
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "countryName", column = @Column(name = "teacher_country")),
           })
    private Address address;  //Basic Value


    //----------------------Collection Value :

    //----------------------Collection Value  1- collection of Basic Value :
    // @ElementCollection : declares an element collection mapping,
    // @ElementCollection : important :: the data for the collection mapping is stored in separate table.
    @ElementCollection
    //@CollectionTable : specifies the name of table that will hold the collection.
    //@CollectionTable : also provides the join column to refer to the primary key
    @CollectionTable(name = "teacher_referee", joinColumns = @JoinColumn(name = "teacher_id"))
    //@Column : the name of column to map the collection data.
    @Column(name = "referee_name")
    private List<String> referee;


    //----------------------Collection Value  *- other Example of collection of basic value
    //Collection
    @ElementCollection
    @CollectionTable(name = "teacher_relation", joinColumns = @JoinColumn(name = "teacher_id"))
    // @MapKeyColumn : the name of key column for map, default value is <property>_key
    @MapKeyColumn(name = "relation_type")
    @MapKeyEnumerated(EnumType.STRING)
    //@Column : the column for map value
    @Column(name = "relative_name")
    private Map<PersonRelationType, String> relation;


    //----------------------Collection Value  2- collection of composite value
    @ElementCollection
    @CollectionTable(name = "teacher_workshop", joinColumns = @JoinColumn(name = "teacher_id"))
    @AttributeOverride(name = "name", column = @Column(name = "workshop_name"))
    //We can also add orderColumn,to track element order/position
    //name of column defaults to <property>_ORDER, here the default name will be workshop_ORDER
    @OrderColumn
    private List<Workshop> workshop;  //Basic Value


    //----------------------Collection Value  *- other example of collection of composite value
    //SortedSet
    @ElementCollection
    @CollectionTable(name = "teacher_workshop_sorted", joinColumns = @JoinColumn(name = "teacher_id"))
    @AttributeOverride(name = "name", column = @Column(name = "workshop_sorted_name"))
    //@OrderBy() : Specifies the order of the elements when the collection is retrieved
    //if ASC or DESC is not specified then ASC is the default
    @OrderBy("workshop_sorted_name asc")
    private Set<Workshop> workshopSorted = new LinkedHashSet<>();  //Basic Value

    //------------------Constructor
    public Teacher(String code) {
        this.code = code;
    }

    public Teacher() {
    }


    //------------------Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getReferee() {
        return referee;
    }

    public void setReferee(List<String> referee) {
        this.referee = referee;
    }

    public Map<PersonRelationType, String> getRelation() {
        return relation;
    }

    public void setRelation(Map<PersonRelationType, String> relation) {
        this.relation = relation;
    }

    public List<Workshop> getWorkshop() {
        return workshop;
    }

    public void setWorkshop(List<Workshop> workshop) {
        this.workshop = workshop;
    }

    public Set<Workshop> getWorkshopSorted() {
        return workshopSorted;
    }

    public void setWorkshopSorted(Set<Workshop> workshopSorted) {
        this.workshopSorted = workshopSorted;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", address=" + address +
                ", referee=" + referee +
                ", relation=" + relation +
                ", workshop=" + workshop +
                ", workshopSorted=" + workshopSorted +
                '}';
    }

    public void setStatus(TeacherStatus status) {
        this.status = status;
    }
}

//////----------------------------------------------------------

///  @ElementCollection :
//can be used to define relationships :
//1 - OneToMany RelationShip to on 'Embeddable' object
//2 - OnyToMany Relationship to a Basic object, such as
//     * java primitive wrappers
//     * String, Date, etc...
//example : private set<String> images = new HashSet<>();


//////----------------------------------------------------------
/////we can have two major types :
//1 - value : don't have their own lifecycle and no identifier.
//2 - Entity : have their own lifecycle and unique identifier.


// categories of value types:
//
//  1- Basic : String, Date, Integer, Boolean, etc...
//  2- Embedded : Address, PhoneNumber (or any custom object)
//  3- Collection : Set, List, Map , ... from any Basic or Composite value , like Workshop
