package board.service;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;

import board.dao.BoardDAO;

public class BoardHitUpdateService {
	public void readUpdate(int bno) {	
		//db연결 dao작업
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean result =dao.hitUpdate(bno);
		
		if(result) {
			commit(con);			
		}else {
			rollback(con);
		}
	}
}
