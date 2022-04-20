package board.service;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardUpdateService {
	public boolean update(BoardDTO updatedto){
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean flag = false;
		
		if(dao.updateArticle(updatedto)) {
			commit(con);
			flag = true; 
		}else {
			rollback(con);
		}
		
		return flag;
	}
}
