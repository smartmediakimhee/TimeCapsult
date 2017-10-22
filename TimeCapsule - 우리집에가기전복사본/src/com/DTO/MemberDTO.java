package com.DTO;

public class MemberDTO {

	private String id;
	private String email;
	private String pw;
	private String name;
	
	
	public MemberDTO(String id, String email, String pw, String name) {
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	


}
