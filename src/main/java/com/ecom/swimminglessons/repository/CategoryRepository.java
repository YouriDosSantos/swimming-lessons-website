package com.ecom.swimminglessons.repository;

import com.ecom.swimminglessons.model.Category;
import com.ecom.swimminglessons.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {//Long is the ID type, Category is the entity
    //the repository is a Data Access Layer
    //JPA repository gives many methods for free such as findAll(), findById(id), save(entity), deleteById(id)

}
