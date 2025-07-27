package com.ecom.swimminglessons.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//Tells Spring Data JPA (or hibernate) to treat this class as a persistent object
//Automatically maps the class to a table with the same name (e.g., Category → category table by default)
//Each field becomes a column in the table (unless excluded with @Transient).
//Requires a field to be marked as a primary key using @Id.
@Entity
@Data //Generates boilerplate code such as getters/setters, toString, equals, hashcode, constructor for final fiends.
public class Category {
//example for Data, You can use category.getName() or category.setName("Beginner") without writing getters/setters manually.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //"One Category can have many Lessons."
    //mappedBy = "category" / This points to the field in the Lesson class that owns the relationship.
    //cascade = CascadeType.ALL:Means that operations (like save, delete) on Category will be cascaded to its products.
    //Example: If you delete a Category, all its products will also be deleted automatically.
    //fetch = FetchType.LAZY:
    //Means products are loaded only when you access the products field, not immediately when you load a Category (better for performance).
    //A Set represents a collection of unique products — no duplicates.
    //It's common to use Set or List for one-to-many relations; Set is preferred if you don't want duplicates and don’t care about order
    //JPA works fine with both, but Set is more efficient when you don't need ordering.


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Lesson> lessons;
}
