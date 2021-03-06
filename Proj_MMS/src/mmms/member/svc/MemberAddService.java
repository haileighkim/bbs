package mmms.member.svc;

import java.sql.Connection;

import mmms.member.dao.MemberDAO;
import mmms.member.db.JdbcUtil;
import mmms.member.vo.Member;

public class MemberAddService {
	public boolean addMember(Member newMember) throws Exception {
		boolean isInsertSuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		int insertCount = memberDAO.insertNewMember(newMember);
		if (insertCount > 0) {
			JdbcUtil.commit(con);
			isInsertSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}

		return isInsertSuccess;
	}
}
