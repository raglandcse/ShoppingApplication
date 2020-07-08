package com.rock.ShoppingApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rock.ShoppingApplication.Model.Product;
import com.rock.ShoppingApplication.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	@Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		 return productRepository.findById(id);
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		  productRepository.save(product);
		
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
