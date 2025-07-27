package com.ecom.swimminglessons.service;

import com.ecom.swimminglessons.datatransfer.CategoryDto;
import com.ecom.swimminglessons.model.Category;
import com.ecom.swimminglessons.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Tells Spring this class holds business logic and should be managed as a service bean
@Service
public class CategoryService { //Handles Business Logic

    //In Service, needs a repository instance
    private final CategoryRepository categoryRepository;

    //inject a CategoryRepository Instance
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    //calls the findAll() Method from the repository
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }

    //NEW
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
    }

    public List<CategoryDto> getAllCategories(){
        return categoryRepository.findAll().stream().map(category -> new CategoryDto(category.getId(), category.getName())).collect(Collectors.toList());
    }
}
