package main;

import com.DB.MemberDAO;
import com.DTO.MemberDTO;

public class LoggedIN {
	public static String Logged_in_id="1";
	
	public static MemberDTO getInfo(){
		
		MemberDAO md = new MemberDAO();
		
		String email = md.selectMember(Logged_in_id).getEmail();
		String pw = md.selectMember(Logged_in_id).getPw();
		String name = md.selectMember(Logged_in_id).getName();
	
		MemberDTO memberDto = new MemberDTO(Logged_in_id, email, pw, name);
		
		return memberDto;
	}
	
	public static MemberDTO setInfo(String id) {
		Logged_in_id = id;
		return getInfo();
	}
}
