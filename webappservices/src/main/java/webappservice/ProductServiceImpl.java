package webappservice;

import webappmodels.Product;

public class ProductServiceImpl implements ProductService {

	public Product getProduct(String productId) {
		return new Product(productId, "Computer", 300);
	}

}
