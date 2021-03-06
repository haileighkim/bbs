package test4.mvc.dao;

import java.util.Vector;
import test4.mvc.dto.Product;
//Interface:강제성,일관성
public interface Dao {
	// abstract method
	void insert(Product p);

	Product select(int num);

	Vector<Product> selectAll();

	void delete(int num);

	void update(int num, Product p);
}
