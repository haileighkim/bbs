package test3;

import java.sql.SQLException;
import java.util.ArrayList;

public class SampleMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		SampleDAO dao = new SampleDAO();
		
		ArrayList<SampleDTO> books = dao.findAll();
		
		//for 출력
		for(SampleDTO s : books) {
			System.out.println("ID: "+s.getId());
			System.out.println("Name: "+s.getName());
			System.out.println("Price: "+s.getPrice());
			System.out.println();
		}
		
		
	}
}
