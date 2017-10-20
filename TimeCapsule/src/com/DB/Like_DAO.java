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
