package test4.mvc.service;

import java.util.Vector;
import test4.mvc.dto.Product;

public interface Service {

	void addProduct();

	Product getProduct();

	Vector<Product> getProducts();

	void delProduct();

	void editProduct();

}
