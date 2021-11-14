package test4.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static DBConnect db = new DBConnect();
	private Connection conn = null;

	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	// 기본생성자
	private DBConnect() {
		try {
			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(url, "javalink", "javalink");

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
		}

	}

	public static DBConnect getInstance() {
		return db;
	}

	// Singleton : 메소드를 통한 객체 생성, 현재 클래스에서 생성
	public Connection getConnection() {
		return conn;
	}

}