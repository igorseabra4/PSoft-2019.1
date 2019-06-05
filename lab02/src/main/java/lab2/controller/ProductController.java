package lab2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lab2.exception.ProductNotFoundException;
import lab2.model.Product;
import lab2.service.ProductService;

@RestController
@RequestMapping({"/v1/products"})
public class ProductController {
	private ProductService productService;
	
	ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
        return "Hello world";
    }
	
	@RequestMapping("/private/greeting")
    public String privateGreeting() {
        return "Hello world! Private";
    }
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Product> findById(@PathVariable long id) throws ProductNotFoundException {
		Product product = productService.findById(id);
		
		if (product == null) {
			throw new ProductNotFoundException("Product not found");
		}
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	@ResponseBody
	public ResponseEntity<List<Product>> findAll()  {
		List<Product> products = productService.findAll();
				
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PostMapping(value = "/private/")
	@ResponseBody
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product newProduct = productService.create(product);
		
		if (newProduct == null)
			throw new InternalError("Something went wrong");
		
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/private/{id}")
	public ResponseEntity delete(@PathVariable long id) {
		try {
			productService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			throw new InternalError("Something went wrong");
		}
	}
	
	@PutMapping(value = "/private/")
	public ResponseEntity<Product> update(@RequestBody Product product) {
		try {
			Product updated = productService.update(product);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			throw  new InternalError("Something went wrong");
		}
	}
}
