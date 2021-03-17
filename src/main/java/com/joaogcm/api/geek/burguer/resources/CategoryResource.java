package com.joaogcm.api.geek.burguer.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.entities.dto.CategoryDTO;
import com.joaogcm.api.geek.burguer.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAllCategories() {
		List<Category> categories = categoryService.findAllCategories();
		List<CategoryDTO> categoriesDTO = categories.stream().map(cat -> new CategoryDTO(cat))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriesDTO);
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
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoryDTO>> findPagesOfCategory(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nameCategory") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<Category> categories = categoryService.findPagesOfCategory(page, linesPerPage, orderBy, direction);
		Page<CategoryDTO> categoriesDTO = categories.map(cat -> new CategoryDTO(cat));
		return ResponseEntity.ok().body(categoriesDTO);
	}
}