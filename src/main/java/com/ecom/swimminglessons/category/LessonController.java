package com.ecom.swimminglessons.category;


import com.ecom.swimminglessons.datatransfer.LessonDto;
import com.ecom.swimminglessons.model.Lesson;
import com.ecom.swimminglessons.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//check notes under category
@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "http://localhost:5173")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@RequestBody @Valid LessonDto dto) {
        LessonDto created = lessonService.createLesson(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonDto> updateLesson(@PathVariable Long id, @RequestBody @Valid LessonDto dto) {
        LessonDto updated = lessonService.updateLesson(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> getAllLessons(){
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<LessonDto>> getAllLessonsByCategory(@PathVariable Long categoryId){
        return ResponseEntity.ok(lessonService.getLessonByCategory(categoryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable Long id) {
        LessonDto lessonDto = lessonService.getLessonById(id);
        return ResponseEntity.ok(lessonDto);
    }


}