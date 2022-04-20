package item.service;
import static item.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import item.dao.ItemDAO;
import item.dto.ItemDTO;

public class ItemSearchService {
	public List<ItemDTO> itemSearch(String category, String name) {
		//db dao
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		//dao
		List<ItemDTO> list = dao.searchList(category, name);
		
		close(con);
		
		return list;
	}
}
