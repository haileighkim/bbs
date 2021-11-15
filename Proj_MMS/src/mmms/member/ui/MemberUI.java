package mmms.member.ui;

import java.util.Scanner;

import mmms.member.action.Action;
import mmms.member.action.MemberAddAction;
import mmms.member.controller.Membercontroller;

public class MemberUI {

	public static void main(String[] args) {
		
		System.out.println("Pull 연습");
		
		System.out.println("Push commit 연습");

		System.out.println("Slave branch 연습");
		
		boolean isStop = false;
		Membercontroller memberController = new Membercontroller();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=====회원관리 프로그램=====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램종료");
			System.out.println("메뉴번호 : ");
			int menu = sc.nextInt();
			Action action = null;
			switch (menu) {
			case 1:
				action = new MemberAddAction(); //1.회원등록
				break;

			default:
				break;
			}

			if (action != null) {
				memberController.processRequest(action, sc);
			}

		} while (!isStop);

	}

}
