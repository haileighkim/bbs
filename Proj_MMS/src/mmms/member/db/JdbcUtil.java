package mmms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		try {
			Class.forName("Oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javalink", "javalink");
			con.setAutoCommit(false); // true인 경우 : commit 실행
								   	 // false인 경우 : commit할 수 있는 시작점 (Transaction시작)
		} catch (SQLException e) {
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {

		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {

		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {

		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {

		}
	}

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {

		}

	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {

		}

	}

}