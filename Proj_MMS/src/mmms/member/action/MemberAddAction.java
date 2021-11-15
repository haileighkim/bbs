package mmms.member.action;

import java.util.Scanner;

import mmms.member.svc.MemberAddService;
import mmms.member.util.ConsoleUtil;
import mmms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getMember(sc); // 회원등록 입력 완성내용
		MemberAddService memberAddService = new MemberAddService();
		boolean isAddSuccess = memberAddService.addMember(newMember);
		if (isAddSuccess)
			cu.PrintAddSuccessMessage(newMember);
		else
			cu.printAddFailMessage(newMember);

	}

}
