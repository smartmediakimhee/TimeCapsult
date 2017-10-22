package com.DTO;

public class Board_1_DTO {
	
	private String title;
	private String content;
	private String maketime;
	private String settime;
	private int id;
	
	public Board_1_DTO(String title, String content, String maketime, String settime, int id) {
		this.title = title;
		this.content = content;
		this.maketime = maketime;
		this.settime = settime;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMaketime() {
		return maketime;
	}

	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}

	public String getSettime() {
		return settime;
	}

	public void setSettime(String settime) {
		this.settime = settime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	//스트링과 스트링을 비교해 
	/*
	if(getColumnType !=Types.TIMESTAMP){	
		System.out.println(rs.getString(columnIndex));
		} else {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss", Locale.KOREA);
		System.out.println(sdf.format(rs.getDate(columnIndex)));*/
/*	
 * sTRINT TO DATE
 * 
	String from = "2013-04-08 10:10:10";

	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Date to = transFormat.parse(from);*/



}
