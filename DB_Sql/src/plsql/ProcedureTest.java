package plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureTest {
	Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
		}
	}

	public void connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!!!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 저장프로시저 호출전 데이터 입력
	public void insert() {
		PreparedStatement pstmt = null;
		connect();
		try {
			String sql = "insert into member3 values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Alpha");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "Al");
			pstmt.setInt(4, 20);
			pstmt.setString(5, "LA");
			pstmt.setString(6, "Alpha@aa.com");
			pstmt.executeUpdate();
			int count = pstmt.executeUpdate();
			if (count > 0)
				System.out.println("insert success!!!");
			else
				System.out.println("insert failed!!");
		} catch (SQLException e) {

		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	public void select() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member3";
		connect();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("ID : " + rs.getString(1) + ", Password : " + rs.getString(2) + ", Name : "
						+ rs.getString(3) + ", Age : " + rs.getString(4) + ", Address : " + rs.getString(5)
						+ ", Email : " + rs.getString(6));
			}
		} catch (SQLException e) {

		} finally {

			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {

			}
		}
	}

	// 저장프로시저 호출 후 데이터 입력
	public void insertMember() {
		CallableStatement cs = null;
		connect();
		try {
			String sql = "{call user_insert(?,?,?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, "Procedure");
			cs.setString(2, "1234");
			cs.setString(3, "Al");
			cs.setInt(4, 20);
			cs.setString(5, "LA");
			cs.setString(6, "Hong@aa.com");
			cs.executeUpdate();
			int count = cs.executeUpdate();
			if (count > 0)
				System.out.println("insert success!!!");
			else
				System.out.println("insert failed!!");
		} catch (SQLException e) {

		} finally {
			try {
				cs.close();
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	public static void main(String[] args) {
		ProcedureTest pt = new ProcedureTest();
		System.out.println("*** Save Procedure calling data ***");
		pt.insert();
		pt.select();
		
	}

}
