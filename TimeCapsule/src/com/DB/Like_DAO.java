package com.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Like_DAO {
	// ���ƿ� ��� �����ϴ� DB
	// ���� : ���ƿ� �� ��� ID, ���ƿ� ��� ĸ�� ID
	// ���� : ��ü ���� �� name.like(���ID, ĸ�� ID)
	// �ߺ� ���� ������ false ��ȯ

	private static Connection conn;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;
	private ResultSet rs;
	boolean result = false;

	private void getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) { // dbConn�� null�̸� Connection ��ü ������..
			// ��������
			String url = "jdbc:oracle:thin:@192.168.0.22:1521:xe";
			String user = "test";
			String pw = "test";

			// JDBC����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ����Ŭ(DBMS)�� �����Ͽ� Connection ��ü ���.
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB����Ϸ�");
		}
	}

	public void dbClose() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("����:ResultSet��ü close():" + e.getMessage());
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("����:PreparedStatement��ü close():" + e.getMessage());
			}
		}

		if (cstmt != null) {
			try {
				cstmt.close();
			} catch (SQLException e) {
				System.out.println("����:CallableStatement��ü close():" + e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("����:Connection��ü close():" + e.getMessage());
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
