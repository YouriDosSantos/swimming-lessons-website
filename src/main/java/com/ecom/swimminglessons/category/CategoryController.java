package com.ecom.swimminglessons.category;

import com.ecom.swimminglessons.datatransfer.CategoryDto;
import com.ecom.swimminglessons.model.Category;
import com.ecom.swimminglessons.repository.CategoryRepository;
import com.ecom.swimminglessons.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//RestController tells Spring this class handles the HTTP Request and return JSON. It combines @Controller (Handles HTTP) and @ResponseBody (auto-converts response to JSON)
@RestController
@RequestMapping("/api/categories") // sets the Base URL path
@CrossOrigin(origins = "http://localhost:5173") //deal with CORS error when Front End was installed and tried to fetch list of lessons
public class CategoryController { //Controller handles incoming API Requests

    // this was used before
    //need to respond to GET request
//        @GetMapping
//        public List<Category> getAllCategories() {
//            return categoryService.getAllCategories();
//        }

    //to get the categories we need a repository
    //we need an instance of service in controller
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //need to respond to GET request
    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

}