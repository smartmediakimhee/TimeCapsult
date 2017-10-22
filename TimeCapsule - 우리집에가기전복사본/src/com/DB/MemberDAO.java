package com.DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.MemberDTO;

public class MemberDAO {
	private static Connection conn;
	private PreparedStatement pstmt;
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

	public boolean insertMember(String email,String pw,String name) {

		boolean result = false;
		try {
			getConnection();

			String sql = "INSERT INTO member VALUES (seq_member_id.nextval,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			
			int r = pstmt.executeUpdate();

			if (r > 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ܹ߻�:insertMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	//�����ȵ�
	public boolean updateMember(String email, String pw, String name) {

		boolean result = false;
		try {
			getConnection();

			String sql = "UPDATE member SET name = ? pw = ? WHERE email =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			
			int r = pstmt.executeUpdate();

			if (r > 0)
				result = true;

		} catch (Exception e) {
			System.out.println("���ܹ߻�:updateMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	//��������
	public ArrayList<MemberDTO> selectAllMember() {
		ArrayList<MemberDTO> dto = new ArrayList<>();
		try {
			getConnection();

			String sql = "SELECT * FROM member";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();

			while (r.next()) {
				String id = r.getString("id");
				String email = r.getString("email");
				String pw = r.getString("pw");
				String name = r.getString("name");
							
				dto.add(new MemberDTO(id, email, pw, name));
			}

		} catch (Exception e) {
			System.out.println("���ܹ߻�:getMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return dto;
	}

	public MemberDTO selectMember(String input_id) {
		MemberDTO dto = null;
		try {
			getConnection();

			String sql = "SELECT * FROM member WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_id);
			ResultSet r = pstmt.executeQuery();

			if(r.next()) {
				String id = r.getString("id");
				String email = r.getString("email");
				String pw = r.getString("pw");
				String name = r.getString("name");
				dto = new MemberDTO(id, email, pw, name);
			}else {
				return dto = null;
			}

		} catch (Exception e) {
			System.out.println("���ܹ߻�:getMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}

		return dto;
	}

	public String selectMember_byname(String name) {
		String dto = "";
		try {
			getConnection();

			String sql = "SELECT * FROM member WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet r = pstmt.executeQuery();

			if(r.next()) {
				dto = r.getString("id");
			}else {
				return dto = null;
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:getMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return dto;
	}
	
	public MemberDTO selectMember_byEmail(String email) {
		MemberDTO dto = null;
		try {
			getConnection();

			String sql = "SELECT * FROM member WHERE email = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet r = pstmt.executeQuery();

			if(r.next()) {
				String id = r.getString("id");
				String email_read = r.getString("email");
				String pw = r.getString("pw");
				String name = r.getString("name");
				dto = new MemberDTO(id, email_read, pw, name);
			}else {
				return dto = null;
			}

		} catch (Exception e) {
			System.out.println("���ܹ߻�:getMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}

		return dto;
	}
	
	public boolean deleteMember(String input_id) {
		boolean result = false;
		try {
			getConnection();

			String sql = "DELETE FROM member WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_id);
			int r = pstmt.executeUpdate();

			if (r > 0)
				result = true;

		} catch (Exception e) {
			System.out.println("���ܹ߻�:deleteMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	/** DB���� ����(�ݱ�) */
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
}
