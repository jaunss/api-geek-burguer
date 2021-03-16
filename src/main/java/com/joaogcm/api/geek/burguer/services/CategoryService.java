package com.joaogcm.api.geek.burguer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.repositories.CategoryRepository;
import com.joaogcm.api.geek.burguer.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public Category findById(Long idCategory) {
		Optional<Category> findCategoryById = categoryRepository.findById(idCategory);
		return findCategoryById.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: ID = " + idCategory));
	}
}