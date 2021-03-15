package com.joaogcm.api.geek.burguer.instantiate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.entities.Product;
import com.joaogcm.api.geek.burguer.repositories.CategoryRepository;
import com.joaogcm.api.geek.burguer.repositories.ProductRepository;

@Configuration
@Profile("test")
public class InstantiateClasses implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category categoryOne = new Category(null, "Drinks");
		Category categoryTwo = new Category(null, "Hamburguers");
		Category categoryThree = new Category(null, "Others");
		
		Product productOne = new Product(null, "Bob Esponja", 16.00);
		Product productTwo = new Product(null, "Florinda-Shake", 15.00);
		Product productThree = new Product(null, "O Senhor dos Aneis", 12.00);
		Product productFour = new Product(null, "Pickle Rick", 24.00);
		
		categoryOne.getProducts().addAll(Arrays.asList(productTwo));
		categoryTwo.getProducts().addAll(Arrays.asList(productOne, productFour));
		categoryThree.getProducts().addAll(Arrays.asList(productThree));
		
		productOne.getCategories().addAll(Arrays.asList(categoryTwo));
		productTwo.getCategories().addAll(Arrays.asList(categoryOne));
		productThree.getCategories().addAll(Arrays.asList(categoryThree));
		productFour.getCategories().addAll(Arrays.asList(categoryTwo));
		
		categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));
		productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFour));
	}
}