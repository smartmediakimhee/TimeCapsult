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
	// 사용법 : 객체 생성 후 name.like(사람ID, 캡슐 ID)
	// 중복 정보 있을시 false 반환

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

	public void dbClose() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("예외:ResultSet객체 close():" + e.getMessage());
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("예외:PreparedStatement객체 close():" + e.getMessage());
			}
		}

		if (cstmt != null) {
			try {
				cstmt.close();
			} catch (SQLException e) {
				System.out.println("예외:CallableStatement객체 close():" + e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("예외:Connection객체 close():" + e.getMessage());
			}
		}

		conn = null;
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
		} finally {
			dbClose();
		}
		return result;
	}

	public boolean isLike(String User_ID, String Capsule_ID) {
		try {
			getConnection();
			String sql = "SELECT * FROM BOARD01_LIKE WHERE MEMBER_ID = ? AND BOARD1_ID = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, User_ID);
			pstmt.setString(2, Capsule_ID);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String db_member_id = rs.getString("member_id");
				String db_table_id = rs.getString("board1_id");
				result = true;
			}



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}

	public String countLike(String Capsule_ID) {
		String result = null;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM BOARD01_LIKE WHERE BOARD1_ID = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Capsule_ID);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				result = rs.getString("COUNT(*)");
			}



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}

	
}
