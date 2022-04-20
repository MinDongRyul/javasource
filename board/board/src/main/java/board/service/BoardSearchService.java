package board.service;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.SearchDTO;

public class BoardSearchService {
	public List<BoardDTO> searchList(SearchDTO searchDto){
		//db dao
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		List<BoardDTO> list = dao.searchList(searchDto);
		
		close(con);
		
		return list;
	}
}	
