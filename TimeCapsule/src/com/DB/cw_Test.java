package com.DB;

import java.util.Scanner;

public class cw_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board_1_DAO b1 = new Board_1_DAO();
		// TODO Auto-generated method stub
		
		System.out.println("������");
		String title = sc.nextLine();
		System.out.println("�۳���");
		String content = sc.nextLine();
		System.out.println("���ѽð�");
		String settime = "2017-10-20 10:00:00";
		
		LoggedIN.Logged_in = "1";
		
		b1.insertBoard_1(title, content, settime);
		
		
	}

}
