package member.service;

import java.sql.Connection;
import static member.dao.JdbcUtil.*;
import member.dao.MemberDAO;

public class MemberModifyService {
	public boolean update(int no, String input, int id) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.updateMember(no, input, id)) {
			commit(con);
			isModifySuccess = true;
		}else {
			rollback(con);
		}
		
		return isModifySuccess;
	}
}
