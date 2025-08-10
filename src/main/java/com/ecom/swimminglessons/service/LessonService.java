package com.ecom.swimminglessons.service;

//import com.ecom.swimminglessons.exception.ResourceNotFoundException;
import com.ecom.swimminglessons.datatransfer.LessonDto;
import com.ecom.swimminglessons.error.ResourceNotFoundException;
import com.ecom.swimminglessons.model.Category;
import com.ecom.swimminglessons.model.Lesson;
import com.ecom.swimminglessons.repository.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CategoryService categoryService;


    public LessonService(LessonRepository lessonRepository, CategoryService categoryService) {
        this.lessonRepository = lessonRepository;
        this.categoryService = categoryService;
    }
    public List<LessonDto> getAllLessons(){
        return lessonRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Transactional
    public LessonDto createLesson(LessonDto dto) {
        Category category = categoryService.getCategoryById(dto.getCategoryId());
        Lesson lesson = new Lesson();
        lesson.setName(dto.getName());
        lesson.setDescription(dto.getDescription());
        lesson.setImageUrl(dto.getImageUrl());
        lesson.setPrice(dto.getPrice());
        lesson.setDuration(dto.getDuration());
        lesson.setCategory(category);
        Lesson saved = lessonRepository.save(lesson);
        return toDto(saved);
    }

    @Transactional
    public LessonDto updateLesson(Long id, LessonDto dto) {
        Lesson existing = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found: " + id));

        if (dto.getCategoryId() != null) {
            Category category = categoryService.getCategoryById(dto.getCategoryId());
            existing.setCategory(category);
        }

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setImageUrl(dto.getImageUrl());
        existing.setPrice(dto.getPrice());
        existing.setDuration(dto.getDuration());

        Lesson saved = lessonRepository.save(existing);
        return toDto(saved);
    }

    @Transactional
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lesson not found: " + id);
        }
        lessonRepository.deleteById(id);
    }

    public LessonDto getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));
        return toDto(lesson);  // assuming you have a method to convert entity to dto
    }


    public List<LessonDto> getLessonByCategory(Long categoryId) {
        return lessonRepository.findByCategoryId(categoryId).stream().map(this::toDto).collect(Collectors.toList());
    }

    private LessonDto toDto(Lesson lesson) {
        return new LessonDto(
                lesson.getId(),
                lesson.getName(),
                lesson.getDescription(),
                lesson.getImageUrl(),
                lesson.getPrice(),
                lesson.getDuration(),
                lesson.getCategory() != null ? lesson.getCategory().getId() : null
        );
    }

}
