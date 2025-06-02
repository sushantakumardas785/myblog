package com.myblog11.controllers;

import com.myblog11.payloads.ApiResponse;
import com.myblog11.payloads.CategoryDto;
import com.myblog11.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //POST-create
    @PostMapping("/")
    public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategoryDto=this.categoryService.createCategory(categoryDto);
        return new  ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }
    //PUT-update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(updatedCategory);
    }
    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully",true),HttpStatus.OK);
    }
    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>getCategory(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }
    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
