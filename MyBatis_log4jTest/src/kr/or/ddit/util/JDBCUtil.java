package kr.or.ddit.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	static { //클래스를  호출할 때 단 한번 사용되는 블럭.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("드라이버 로딩 완료!");
			
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	/**
	 * Connection 객체 생성 메서드
	 * @return Connection 객체, 에외 발생시 null 
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc02", "java");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 자원반납을 위한 메서드
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try {rs.close();} catch(SQLException e){e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e){e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e){e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e){e.printStackTrace();}
	}
	public static void main(String[] args) {
		
	}
}
