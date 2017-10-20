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

public class Board_1_DAO {
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
	//*�߰��ڵ�
	public boolean insertBoard_1(String title,String content,String settime) {

		boolean result = false;
		try {
			
			MyLocation ml = new MyLocation(); 
			MyWeather mw = new MyWeather();
			NowTime nt = new NowTime(); 
			String weather=mw.getWeather(ml.getLocation()); 
			String nowTime = nt.getTime();
			
			
			getConnection();
			
			String board_sql = "INSERT INTO board_type1 VALUES (?,?,sysdate,?,board_1_id.nextVal)";
			
			PreparedStatement pstmt = conn.prepareStatement(board_sql);
						
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, settime);
			
			int r = pstmt.executeUpdate();

			if (r > 0) {
				String rel_sql = "INSERT INTO rel_member_board1 VALUES (SEQ_REL_MEM_BRD_ID.NEXTVAL,?,board_1_id.CURRVAL)";
				PreparedStatement pstmt2 = conn.prepareStatement(rel_sql);
				pstmt2.setString(1, LoggedIN.Logged_in); //Member ID
				System.out.println(LoggedIN.Logged_in);
				int r2 = pstmt2.executeUpdate();
				if(r2>0)
					result=true;
			}
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ܹ߻�:insertMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	//�����ȵ�
	public boolean updateBoard_1(String name) {

		boolean result = false;
		try {
			getConnection();

			String sql = "UPDATE member SET pw = ? name = ? WHERE name =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, name);

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

	public ArrayList<Board_1_DTO> selectAllBoard1() {
		ArrayList<Board_1_DTO> dto = new ArrayList<>();
		try {
			getConnection();

			String sql = "SELECT * FROM board_type1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();

			while (r.next()) {
				String title = r.getString("title");
				String content = r.getString("content");
				String maketime = r.getString("maketime");
				String settime = r.getString("settime");
				int id = r.getInt("id");
						
				dto.add(new Board_1_DTO(title, content, maketime, settime, id));
			}

		} catch (Exception e) {
			System.out.println("���ܹ߻�:getMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}
		return dto;
	}

	public Board_1_DTO selectBoard_1_DTO(String id) {
		Board_1_DTO dto = null;
		try {
			getConnection();

			String sql = "SELECT * FROM member WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet r = pstmt.executeQuery();

			if(r.next()) {
				String id2 = r.getString("id");
				String pw = r.getString("pw");
				String name = r.getString("name");
						
			}

		} catch (Exception e) {
			System.out.println("���ܹ߻�:getMember()=> " + e.getMessage());
		} finally {
			dbClose();
		}

		return dto;
	}

	//��
	public boolean deleteBoard_1(String id) {
		boolean result = false;
		try {
			getConnection();

			String sql = "DELETE FROM board_type1 WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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