package com.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.Board_1_DTO;
import com.DTO.FriendDTO;
import com.DTO.MemberDTO;

public class Friend_DAO {
	private static Connection conn;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;
	private ResultSet rs;
	boolean result = false;
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) { // dbConn�� null�̸� Connection ��ü ������..
			// ��������
			String url = "jdbc:oracle:thin:@"+main.LoggedIN.dbIP+":1521:xe";
			String user = "test";
			String pw = "test";

			// JDBC����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ����Ŭ(DBMS)�� �����Ͽ� Connection ��ü ���.
			conn = DriverManager.getConnection(url, user, pw);
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

	public boolean add(String User_ID, String Friend_ID) { //ģ���߰�

		try {
			getConnection();
			
			String sql = "INSERT INTO FRIEND VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, User_ID);
			pstmt.setString(2, Friend_ID);
			
			int r = pstmt.executeUpdate();
			
			if(r>0) result = true;
			
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

	public ArrayList<FriendDTO> list(String logged_in) { //ģ�� ��� �ҷ�����
		
		ArrayList<FriendDTO> friendList = new ArrayList<>();
		
		try {
			getConnection();
			String sql = "SELECT TARGET_ID FROM FRIEND WHERE SHOOT_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logged_in);
			ResultSet r = pstmt.executeQuery();
			
			while(r.next()) {
				//���� ���̵� �Է¹޾� ģ�� ��� ��ü�� ��̸���Ʈ�� ��ȯ�ϱ�
				String get_id = r.getString("TARGET_ID");
				MemberDAO md = new MemberDAO();
				
				String para_id = get_id;
				String para_email = md.selectMember(get_id).getEmail();
				String para_name = md.selectMember(get_id).getName();
				friendList.add(new FriendDTO(para_id,para_email,para_name));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return friendList;
	};

}
