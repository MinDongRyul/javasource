package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;
import member.dao.MemberDAO;

public class MemberModifyService {
	public boolean modify(String new_password, String userid) {
		//db작업
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con); 
		
		//dao작업
		boolean result = dao.changePassword(new_password, userid);
		if(result) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}
}
