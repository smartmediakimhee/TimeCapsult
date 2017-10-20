package com.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Like_DAO {
	// 좋아요 기능 구현하는 DB
	// 구성 : 좋아요 한 사람 ID, 좋아요 대상 캡슐 ID

	private static Connection conn;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;
	private ResultSet rs;
	boolean result = false;
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) { // dbConn이 null이면 Connection 객체 얻어오기..
			// 접속정보
			String url = "jdbc:oracle:thin:@192.168.0.22:1521:xe";
			String user = "test";
			String pw = "test";

			// JDBC드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클(DBMS)에 연결하여 Connection 객체 얻기.
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB연결완료");
		}
	}

	public boolean like(String User_ID, String Capsule_ID) {
		try {
			getConnection();
			String sql = "INSERT INTO BOARD01_LIKE VALUES (?,?)";
			
			String user_id = User_ID;
			String board_id = Capsule_ID;
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, board_id);
			
			int r = pstmt.executeUpdate();
			
			if (r > 0)
				result = true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
