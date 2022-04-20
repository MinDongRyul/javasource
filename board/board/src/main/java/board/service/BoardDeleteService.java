package board.service;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;

import board.dao.BoardDAO;

public class BoardDeleteService {
	public boolean remove(int bno, String password) {
		// db연결 dao작업
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean result = dao.deleteArticle(bno, password);
		
		if(result) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);
		
		return result;
	}
}	
