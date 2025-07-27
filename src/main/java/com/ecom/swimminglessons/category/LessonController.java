package com.ecom.swimminglessons.category;


import com.ecom.swimminglessons.model.Lesson;
import com.ecom.swimminglessons.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//check notes under category
@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "http://localhost:5173")
public class LessonController {

    //Final means it needs to be initialized through the constructor
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    //This constructor uses dependency injection — Spring will automatically provide the LessonService when creating this controller.

    //this is mapped to the /api/lessons
    @GetMapping
    public List<Lesson> getAllLessons (){
        return lessonService.getAllLessons();
    }

    //the categoryId within the {} in the getmapping is related to the PathVariable as a parameter
    //Moreover, RequestMapping is within the GET mapping annotation
    @GetMapping("category/{categoryId}")
    public List<Lesson> getAllLessonsByCategory(@PathVariable Long categoryId){
        return lessonService.getLessonByCategory(categoryId);
    }
}