package lab2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab2.dao.ProductDAO;
import lab2.exception.ProductNotFoundException;
import lab2.model.Product;

@Service
public class ProductService {
	private final ProductDAO<Product, Long> productDAO;
	
	ProductService(ProductDAO<Product, Long> productDAO) {
		this.productDAO = productDAO;
	}
	
	public Product create(Product product) {
		return productDAO.save(product);
	}
	
	public Product update(Product productToUpdate) throws ProductNotFoundException {
		Product product = productDAO.findById(productToUpdate.getId());
		if (product == null)
			throw new ProductNotFoundException("Could not update. The product does not exist.");

		return productDAO.save(productToUpdate);
	}
	
	public void delete(long id) {
		productDAO.deleteById(id);
	}

	public Product findById(long id) {
		return productDAO.findById(id);
	}

	public List<Product> findAll() {
		return productDAO.findAll();
	}
}