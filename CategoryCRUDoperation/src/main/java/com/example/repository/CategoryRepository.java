package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Category;
import com.example.demo.entity.*;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Optional<Category> findAllById(long id);

	void deleteById(long id);

	Optional<Category> fifindByIdd(long id);

}
