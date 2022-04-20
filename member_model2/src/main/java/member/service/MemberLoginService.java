package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberLoginService {
	public MemberDTO login(String userid, String password) {
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO logindto = dao.isLogin(userid, password);
		
		close(con);
		
		return logindto;
	}
}
