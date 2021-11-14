package test4.mvc.service;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dao.Dao;
import test4.mvc.dao.OracleDao;
import test4.mvc.dto.Product;

public class ServiceImpl implements Service {
	Scanner sc = new Scanner(System.in);
	Dao dao = new OracleDao();

	@Override
	public void addProduct() { // insert
		System.out.println("Product Name?");
		String name = sc.next();
		System.out.println("Product Price?");
		int price = sc.nextInt();

		Product p = new Product(0, name, price);
		dao.insert(p);
	}

	@Override
	public Product getProduct() { // select one
		System.out.println("Searching for..(num)?");
		int num = sc.nextInt();
		Product p = dao.select(num);
		return p;
	}

	@Override
	public Vector<Product> getProducts() { // select all
		Vector<Product> v = dao.selectAll();
		return v;
	}

	@Override
	public void delProduct() { // delete
		System.out.println("Delete..?(num)");
		int num = sc.nextInt();
		dao.delete(num);
	}

	@Override
	public void editProduct() { // update
		System.out.println("Correction..?(num)");
		
		int num = sc.nextInt();
		Product p = dao.select(num);
		System.out.println(p);
		
		System.out.println("Correction..?(name)");
		String name = sc.next();
		System.out.println("Correction..?(price)");
		int price = sc.nextInt();
		p.setName(name);		
		p.setPrice(price);
		
		dao.update(p.getNum(), p);
	}

}
