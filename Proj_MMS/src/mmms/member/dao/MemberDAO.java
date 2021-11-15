package mmms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import mmms.member.db.JdbcUtil;
import mmms.member.vo.Member;

public class MemberDAO {
	Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	// 1.회원등록
	public int insertNewMember(Member newMember) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO mms_member VALUES(mms_member_id_seq.nextval,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {

		} finally {
			JdbcUtil.close(pstmt);
		}
		return insertCount;
	}

	// 2.회원목록보기
	public ArrayList<Member> selectMemberList() {

		return null;
	}

	// 3.특정 회원 정보 보기
	public Member selectOldMember(String name) {
		return null;
	}

	// 4.회원정보 수정
	public int updateMember(Member updateMember) {
		return 0;
	}

	// 5.회원정보삭제
	public int deleteMember(String name) {
		return 0;

	}

}
