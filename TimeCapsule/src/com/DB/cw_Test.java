package com.DB;

import java.util.ArrayList;
import java.util.Scanner;

import com.DTO.FriendDTO;

public class cw_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board_1_DAO b1 = new Board_1_DAO();
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
//		Like_DAO ld = new Like_DAO();
//		
//		ld.like(LoggedIN.Logged_in, "5");

		
		//ģ�� ��� ����
		Friend_DAO fd = new Friend_DAO();
		
		//ģ�� �߰�
//		fd.add(LoggedIN.Logged_in, "2");
		
		//ģ�� ���
		ArrayList<FriendDTO> list=fd.list(LoggedIN.Logged_in);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(1).getEmail());
		}
		
		
	}

}
