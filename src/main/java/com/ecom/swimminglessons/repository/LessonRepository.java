package com.ecom.swimminglessons.repository;

import com.ecom.swimminglessons.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    //JPA library uses the term BY = Where in SQL to automate the process below. category_id is a field in Lesson. Finding convention is best practices
    //SELECT * FROM lesson WHERE category_id = ?
    //This works because your Lesson entity has a field named category which is a @ManyToOne with a Category entity.
    //JPA knows how to reach category.id via categoryId.
    List<Lesson> findByCategoryId(Long categoryId);
}
