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
		
//		System.out.println("������");
//		String title = sc.nextLine();
//		System.out.println("�۳���");
//		String content = sc.nextLine();
//		System.out.println("���ѽð�");
//		String settime = "2017-10-20 10:00:00";
//		
//		LoggedIN.Logged_in = "1";
//		
//		b1.insertBoard_1(title, content, settime);
		
		//���ƿ� ��� �����غ���
//		
//		likeDao.like(LoggedIN.Logged_in, "5");

		//ģ�� �߰�
//		fd.add(LoggedIN.Logged_in, "2");
		
		//ģ�� ���
//		ArrayList<FriendDTO> list=fd.list(LoggedIN.Logged_in_id);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(1).getEmail()+" ");
//			System.out.println(list.get(1).getName());
//		}
		
		//���� �α��� ���� ��������
		//System.out.println(LoggedIN.getInfo().getName()); // �г��� ���� ��������
		//System.out.println(LoggedIN.getInfo().getEmail()); // �̸������� ��������
		
		//���� ���ƿ� �� ������ �Ǵ�
		//���� : ��ü ���� �� ��ü�� �޼ҵ� �� isLike(�������̵�, ĸ�� ���̵�) �� ȣ���ϸ� �� ������ �� ĸ���� ���ƿ� �ߴ��� true, false �� ��ȯ�Ѵ�. 

//		System.out.println(likeDao.isLike("1","4"));
		
		//Ư�� ������ �� ĸ�� �������� ��ȯ�� : ArrayList<Board_1_DTO>
//		
//		b1.selectMembersCapsules("1");
		
		//���ƿ� �� ��������
//		System.out.println(likeDao.countLike(2));
//		MyWeather mw = new MyWeather();
//		System.out.println(mw.getWeather());
		
		
		//��� ���̵�� ĸ������(��̸���Ʈ) ��ȸ
//		b1.selectMembersCapsules("47").get(0).getContent();
//		
//		System.out.println(b1.getWeather(104));
		
		System.out.println("�����Ϸ�");
		
	}

}
