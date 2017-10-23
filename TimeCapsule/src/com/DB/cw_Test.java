package com.DB;

import java.util.ArrayList;
import java.util.Scanner;

import com.DTO.Board_1_DTO;
import com.DTO.FriendDTO;

import function.MyWeather;
import main.LoggedIN;

public class cw_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board_1_DAO b1 = new Board_1_DAO();
		Like_DAO likeDao = new Like_DAO();
		Friend_DAO fd = new Friend_DAO();
		MemberDAO md = new MemberDAO();
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
//		
//		likeDao.like(LoggedIN.Logged_in, "5");

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

//		System.out.println(likeDao.isLike("1","4"));
		
		//특정 유저가 쓴 캡슐 가져오기 반환형 : ArrayList<Board_1_DTO>
//		
//		b1.selectMembersCapsules("1");
		
		//좋아요 수 가져오기
//		System.out.println(likeDao.countLike(2));
//		MyWeather mw = new MyWeather();
//		System.out.println(mw.getWeather());
		
		
		//멤버 아이디로 캡슐정보(어레이리스트) 조회
//		b1.selectMembersCapsules("47").get(0).getContent();
//		
//		System.out.println(b1.getWeather(104));
		
		System.out.println("수정완료");
		
	}

}
