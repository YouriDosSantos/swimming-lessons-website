package com.ecom.swimminglessons.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lesson {
    //id for primary key
    //generate value incrementally
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private int duration;

    //many Lessons belong to a single category
    //there will be a foreign_id column called category_id
    //nullable = false, every lesson must have a category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
//    @JsonIgnoreProperties({"lessons"})
    @JsonBackReference
    private Category category;
}
