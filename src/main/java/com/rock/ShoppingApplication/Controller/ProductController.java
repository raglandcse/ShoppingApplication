package com.rock.ShoppingApplication.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rock.ShoppingApplication.Model.Product;
import com.rock.ShoppingApplication.Model.ProductDto;
import com.rock.ShoppingApplication.Service.ProductService;

@RestController
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestParam("imageFile") MultipartFile file,
			@RequestBody ProductDto productDto) throws IOException {

		Product product = new Product();
		product.setName(productDto.getName());
		product.setImage(compressBytes(file.getBytes()));
		product.setActualprice(new BigDecimal(productDto.getActualprice()));
		product.setDiscountedprice(new BigDecimal(productDto.getDiscountedprice()));

		productService.saveProduct(product);
		return ResponseEntity.ok("Sucessfully inserted");

	}

	@GetMapping("/getAllProduct")
	private ResponseEntity<List<Product>> getAllProduct() {
		
		List<Product> listofProduct=productService.getAllProduct();
		return new ResponseEntity<List<Product>>(listofProduct, HttpStatus.OK);

	}
	
	@GetMapping("/Product/{productId}")
	private ResponseEntity<Product> getsingleProduct(@PathVariable("productId") Long productId) {
		
		return new ResponseEntity<Product>(productService.findById(productId).get(), HttpStatus.OK);

	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}
