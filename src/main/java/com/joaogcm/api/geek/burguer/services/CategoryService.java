package com.joaogcm.api.geek.burguer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.entities.dto.CategoryDTO;
import com.joaogcm.api.geek.burguer.repositories.CategoryRepository;
import com.joaogcm.api.geek.burguer.services.exceptions.DataIntegrityException;
import com.joaogcm.api.geek.burguer.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public Category findCategoryById(Long idCategory) {
		Optional<Category> findCategoryById = categoryRepository.findById(idCategory);
		return findCategoryById
				.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: ID = " + idCategory));
	}

	public Category insertCategory(Category category) {
		try {
			category.setIdCategory(null);
			return categoryRepository.save(category);

		} catch (Exception e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}

	public Category updateCategoryById(Category category) {
		try {
			findCategoryById(category.getIdCategory());
			return categoryRepository.save(category);

		} catch (Exception e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}

	public void deleteCategoryById(Long idCategory) {
		try {
			findCategoryById(idCategory);
			categoryRepository.deleteById(idCategory);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover uma Categoria que possui Produtos.");
		}
	}

	public Page<Category> findPagesOfCategory(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequestOfCategory = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoryRepository.findAll(pageRequestOfCategory);
	}

	public Category fromDTO(CategoryDTO categoryDTO) {
		return new Category(categoryDTO.getIdCategory(), categoryDTO.getNameCategory());
	}
}