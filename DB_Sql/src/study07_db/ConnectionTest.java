package study07_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver");
		}
	}

	public void connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!!!");
		} catch (SQLException e) {
			System.out.println("Address, ID, PW are not matching");
		}
	}

	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}

}
