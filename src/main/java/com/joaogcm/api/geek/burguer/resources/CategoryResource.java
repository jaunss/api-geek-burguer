package com.joaogcm.api.geek.burguer.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Category> categories = categoryService.findAll();
		return ResponseEntity.ok().body(categories);
	}

	@GetMapping(value = "/{idCategory}")
	public ResponseEntity<?> findById(@PathVariable Long idCategory) {
		Category findCategoryById = categoryService.findById(idCategory);
		return ResponseEntity.ok().body(findCategoryById);
	}
}