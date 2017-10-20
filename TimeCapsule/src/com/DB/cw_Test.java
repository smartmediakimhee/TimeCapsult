package com.DB;

import java.util.ArrayList;
import java.util.Scanner;

import com.DTO.FriendDTO;

public class cw_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board_1_DAO b1 = new Board_1_DAO();
		// TODO Auto-generated method stub
		
//		System.out.println("글제목");
//		String title = sc.nextLine();
//		System.out.println("글내용");
//		String content = sc.nextLine();
//		System.out.println("제한시간");
//		String settime = "2017-10-20 10:00:00";
//		
//		LoggedIN.Logged_in = "1";
//		
//		b1.insertBoard_1(title, content, settime);
		
		//좋아요 기능 구현해보자
//		Like_DAO ld = new Like_DAO();
//		
//		ld.like(LoggedIN.Logged_in, "5");

		
		//친구 기능 구현
		Friend_DAO fd = new Friend_DAO();
		
		//친구 추가
//		fd.add(LoggedIN.Logged_in, "2");
		
		//친구 목록
		ArrayList<FriendDTO> list=fd.list(LoggedIN.Logged_in);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(1).getEmail());
		}
		
		
	}

}
