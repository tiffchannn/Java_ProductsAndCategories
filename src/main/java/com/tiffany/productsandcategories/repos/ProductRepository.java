package com.tiffany.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tiffany.productsandcategories.models.Category;
import com.tiffany.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
	List<Product> findByCategoriesContaining(Category category);
}
