package com.ecom.swimminglessons.service;

//import com.ecom.swimminglessons.exception.ResourceNotFoundException;
import com.ecom.swimminglessons.model.Lesson;
import com.ecom.swimminglessons.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;


    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    //find all products in the database/repository
    public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }

    //NEW
    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public List<Lesson> getLessonByCategory(Long categoryId) {
        //findById did not show initially so we had to create it under the repository
        List<Lesson> lessons = lessonRepository.findByCategoryId(categoryId);
        return lessons;
    }
}
