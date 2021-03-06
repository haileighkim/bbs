package mmms.member.util;

import java.util.Scanner;
import mmms.member.vo.Member;

public class ConsoleUtil {

	public Member getMember(Scanner sc) {
		System.out.println("등록할 회원정보를 입력하세요");
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("주소 : ");
		String addr = sc.next();
		
		System.out.println("이메일 : ");
		String email = sc.next();
		
		System.out.println("국가 : ");
		String nation = sc.next();
		
		System.out.println("나이 : ");
		int age = sc.nextInt();

		return new Member(name, addr, email, nation, age);
	}

	public void PrintAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + "회원 정보 추가 성공");
	}

	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + "회원 정보 추가 실패");
	}
	
	//2.
}
