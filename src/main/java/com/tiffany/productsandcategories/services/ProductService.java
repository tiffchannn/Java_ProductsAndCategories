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
public class ProductService {
	@Autowired
	private CategoryRepository categoryRepo;
	private ProductRepository productRepo;

	public ProductService(ProductRepository productRepo, 
						  CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	 // returns all the categories
    public List<Product> allProducts() {
        return productRepo.findAll();
    }
    // creates a product
    public Product createProduct(Product p) {
        return productRepo.save(p);
    }
    
    // retrieves a product
    public Product findProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isPresent()) {
            return product.get();
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
    
    // find products that don't contain the product
    public List<Category> allExcludeCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
    
    public List<Product> allExcludeProducts(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
    
 // list of products that CONTAIN a category
    public List<Product> allContainProduct(Category category) {
    	return productRepo.findByCategoriesContaining(category);
    }
    
    // adds the connection between each
    public Product updateProduct(Product p) {
		return productRepo.save(p);
	}
}
