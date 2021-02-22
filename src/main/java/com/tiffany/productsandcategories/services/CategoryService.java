package com.tiffany.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiffany.productsandcategories.models.Category;
import com.tiffany.productsandcategories.models.Product;
import com.tiffany.productsandcategories.repos.CategoryRepository;
import com.tiffany.productsandcategories.repos.ProductRepository;



@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	private ProductRepository productRepo;
	
	public CategoryService(ProductRepository productRepo, 
			  			   CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	 // returns all the categories
    public List<Category> allCategories() {
        return categoryRepo.findAll();
    }
    // creates a category
    public Category createCategory(Category c) {
        return categoryRepo.save(c);
    }
    // retrieves a category
    public Category findCategory(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isPresent()) {
            return category.get();
        } else {
            return null;
		}
	}
    
    public Category findCategoryById(Long Id) {
		Optional<Category> checkCategory = categoryRepo.findById(Id);
		if(checkCategory.isPresent()) {
			return checkCategory.get();
		}
		else {
			return null;
		}
	}
    
    public Product findProductById(Long id) {
		Optional<Product> checkProduct =  productRepo.findById(id);
		if (checkProduct.isPresent()) {
			return checkProduct.get();
		}
		else {
			return null;
		}
	}

    
    // categories that are NOT containing product
    public List<Category> allExcludeCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
    
    // list of products that don't contain the category
    public List<Product> allExcludeProducts(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
    
    // list of categories that CONTAIN a product
    public List<Category> allContainCategory(Product product) {
    	return categoryRepo.findByProductsContaining(product);
    }
    
    public Category updateCategory(Category c) {
		return categoryRepo.save(c);
	}
}
