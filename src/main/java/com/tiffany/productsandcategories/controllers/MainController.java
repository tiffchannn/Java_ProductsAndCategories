package com.tiffany.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiffany.productsandcategories.models.Category;
import com.tiffany.productsandcategories.models.Product;
import com.tiffany.productsandcategories.services.CategoryService;
import com.tiffany.productsandcategories.services.ProductService;


@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	// Dashboard Page
	@GetMapping("/")
	public String index(Model model) {
        List<Category> categories = categoryService.allCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("products", productService.allProducts());
        return "index.jsp";
	}
	
	@RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "newProduct.jsp";
    }
	
	// Create new product
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error creating a product!");
			return "newProduct.jsp";
		} else {
			productService.createProduct(product);
			System.out.println("Product was created! " + product.getName());
			return "redirect:/";
		}
	}
	
	@RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "newCategory.jsp";
    }
	
	// Create new category
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error creating a category!");
			return "newCategory.jsp";
		} else {
			categoryService.createCategory(category);
			System.out.println("Category was created! " + category.getName());
			return "redirect:/";
		}
	}
	
	// Show specific product's info
	@GetMapping("/products/{id}")
	public String showProductInfo(@PathVariable("id")Long id, Model model){
		Product product = productService.findProduct(id);
		model.addAttribute("product", productService.findProduct(id));
		// get category list for a specific product
		model.addAttribute("categoryList", product.getCategories());
		model.addAttribute("categories",productService.allExcludeCategories(productService.findProductById(id)));
		return "productInfo.jsp";
    }
	
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(@RequestParam Long categoryId, @PathVariable Long id, Model model) {
		Product product = productService.findProduct(id);
		Category category = categoryService.findCategory(categoryId);
		System.out.println("Added category to product");
		product.getCategories().add(category);
		productService.updateProduct(product);
		System.out.println("Added " + category.getName() + " to " + product.getName());
		return"redirect:/products/" + id;
		
	}
	
	// Show specific categorie's info
	@GetMapping("/categories/{id}")
    public String showCategoryInfo(@PathVariable("id")Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("productList", category.getProducts());
		model.addAttribute("category",productService.findCategoryById(id));
		model.addAttribute("products",productService.allExcludeProducts(productService.findCategoryById(id)));
    	return "categoryInfo.jsp";
    }
	
	@PostMapping("categories/{id}")
	public String addProductToCategory(@RequestParam Long productId, @PathVariable Long id, Model model) {
		Product product = productService.findProduct(productId);
		Category category = categoryService.findCategory(id);
		System.out.println("Added product to category!");
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		System.out.println("Added " + product.getName() + " to category: " + category.getName());
		return"redirect:/categories/" + id;
	}
	
}


//@PostMapping("/products/{id}")
//public String addCategoryToProduct(@PathVariable("id")Long id, @RequestParam Long categoryId) {
//	Category category = categoryService.findCategory(categoryId);
//	Product product = productService.findProduct(id);
//	product.getCategories().add(category);
//	productService.joinCategoryToProduct(category);
//}

//// Display all categories
//@GetMapping("/categories")
//public String showCategories(@ModelAttribute("category") Category category, Model model) {
////	model.addAttribute("products", productService.allProducts()); // display all products
//	model.addAttribute("categories", categoryService.allCategories()); // display all categories
//	return "categories.jsp";
//}
//
//// Display all products
//@GetMapping("/products")
//public String showProducts(@ModelAttribute("product") Product product, Model model) {
//	model.addAttribute("products", productService.allProducts()); // now we can show all products in jsp
//	return "products.jsp";
//}