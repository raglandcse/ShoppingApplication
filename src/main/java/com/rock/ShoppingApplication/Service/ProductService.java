package com.rock.ShoppingApplication.Service;

import java.util.List;
import java.util.Optional;

import com.rock.ShoppingApplication.Model.Product;

public interface ProductService {

	Optional<Product> findById(Long id);
	
	public void saveProduct(Product product);
	
	public List<Product> getAllProduct();
}
