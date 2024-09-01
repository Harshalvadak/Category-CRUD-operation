package com.example.controller;

import com.example.demo.entity.*;

import com.example.repository.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class Categorycontroller {
	 
	@Autowired
	CategoryRepository repo;
	
	//get all category
	@GetMapping("/categories")
	public  List<Category>getAllCategory()
	{
		List<Category> category =repo.findAll();
		return category;
	}
	
	@GetMapping("/categories/{id}")
	public Category getStudent(@PathVariable int id) {
		Category Category = repo.findById(id).get();
		
		return Category;
	}
	
	@DeleteMapping("/categories/{id}")
	public String deleteCategoryId(@PathVariable int id) {
		repo.deleteById((long) id);
		return "Category Deleted Successfully";
	}
	
	@PostMapping("/student/add")
	public ResponseEntity<Category> createStudent(@RequestBody Category Category) {
		Category newCategory = repo.save(Category);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
		
	}	
	@PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category categories) {
        Optional<Category> existingCategory = repo.fifindByIdd(id);
        if (existingCategory.isPresent()) {
        	Category updatedCategory = existingCategory.get();
            updatedCategory.setCategory_name(categories.getCategory_name());
            updatedCategory.setCategory_name(categories.getCategory_price());
            repo.save(updatedCategory);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
