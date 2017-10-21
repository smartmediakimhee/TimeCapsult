package com.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.Board_1_DTO;

import function.MyLocation;
import function.MyWeather;
import function.NowTime;
import main.LoggedIN;

public class Rel_Mem_Cap {
	private static Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	private CallableStatement cstmt;
	private ResultSet rs;
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

	public ArrayList<String> membersCapsule(String member_id) {
		ArrayList<String> capsuleList = new ArrayList<String>();
		try {
			getConnection();
			

			String sql = "SELECT * FROM REL_MEMBER_BOARD1 WHERE MEMBER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member_id);
			
			ResultSet r = pstmt.executeQuery();
			
				System.out.println();

			while (r.next()) {
				capsuleList.add(r.getString("BOARD1_ID"));
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

		

		
		return capsuleList;
	}
}