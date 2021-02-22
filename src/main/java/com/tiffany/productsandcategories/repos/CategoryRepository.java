package com.tiffany.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tiffany.productsandcategories.models.Category;
import com.tiffany.productsandcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	List<Category> findByProductsContaining(Product product);
}
