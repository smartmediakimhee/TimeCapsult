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
			System.out.println("예외발생:insertMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	//구현안됨
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
			System.out.println("예외발생:updateMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	//구현안함
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
			System.out.println("예외발생:getMember()=> " + e.getMessage());
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
			System.out.println("예외발생:getMember()=> " + e.getMessage());
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
			System.out.println("예외발생:getMember()=> " + e.getMessage());
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
			System.out.println("예외발생:getMember()=> " + e.getMessage());
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
			System.out.println("예외발생:deleteMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	/** DB연결 해제(닫기) */
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
}
