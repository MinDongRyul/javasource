package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;
// return타입은 dao에서 부를 타입과 동일하게 설정

public class MemberRemoveService {
	public boolean remove(int id) {
		
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.removeMember(id)) {	
			commit(con);
			isRemoveSuccess = true;
		}else {
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
}
