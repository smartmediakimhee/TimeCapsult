package com.DB;

import java.util.ArrayList;
import java.util.Scanner;

import com.DTO.FriendDTO;

import main.LoggedIN;

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
//		Friend_DAO fd = new Friend_DAO();
		
		//친구 추가
//		fd.add(LoggedIN.Logged_in, "2");
		
		//친구 목록
//		ArrayList<FriendDTO> list=fd.list(LoggedIN.Logged_in_id);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(1).getEmail()+" ");
//			System.out.println(list.get(1).getName());
//		}
		
		//현재 로그인 정보 가져오기
		//System.out.println(LoggedIN.getInfo().getName()); // 닉네임 정보 가져오기
		//System.out.println(LoggedIN.getInfo().getEmail()); // 이메일정보 가져오기
		
		//내가 좋아요 한 글인지 판단
		//사용법 : 객체 생성 후 객체의 메소드 중 isLike(유저아이디, 캡슐 아이디) 를 호출하면 그 유저가 그 캡슐을 좋아요 했는지 true, false 로 반환한다. 
		Like_DAO likeDao = new Like_DAO();
		System.out.println(likeDao.isLike("1","4"));
		
	}

}
