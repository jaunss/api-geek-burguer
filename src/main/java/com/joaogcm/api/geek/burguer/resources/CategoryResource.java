package com.joaogcm.api.geek.burguer.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> findAllCategories() {
		List<Category> categories = categoryService.findAllCategories();
		return ResponseEntity.ok().body(categories);
	}

	@GetMapping(value = "/{idCategory}")
	public ResponseEntity<?> findCategoryById(@PathVariable Long idCategory) {
		Category findCategoryById = categoryService.findCategoryById(idCategory);
		return ResponseEntity.ok().body(findCategoryById);
	}

	@PostMapping
	public ResponseEntity<?> insertCategory(@RequestBody Category category) {
		category = categoryService.insertCategory(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCategory}")
				.buildAndExpand(category.getIdCategory()).toUri();
		return ResponseEntity.created(uri).body(category);
	}

	@PutMapping(value = "/{idCategory}")
	public ResponseEntity<?> updateCategoryById(@PathVariable Long idCategory, @RequestBody Category category) {
		category.setIdCategory(idCategory);
		category = categoryService.updateCategoryById(category);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{idCategory}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Long idCategory) {
		categoryService.deleteCategoryById(idCategory);
		return ResponseEntity.noContent().build();
	}
}