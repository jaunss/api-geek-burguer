package com.joaogcm.api.geek.burguer.entities.dto;

import java.io.Serializable;

import com.joaogcm.api.geek.burguer.entities.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idCategory;
	private String nameCategory;

	public CategoryDTO() {

	}

	public CategoryDTO(Category category) {
		idCategory = category.getIdCategory();
		nameCategory = category.getNameCategory();
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}