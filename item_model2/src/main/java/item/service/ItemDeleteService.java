package item.service;
import static item.dao.JdbcUtil.*;

import java.sql.Connection;

import item.dao.ItemDAO;

public class ItemDeleteService {
	public boolean deleteItem(int num) {	
		//db 연결
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
	
		//dao
		boolean result = dao.delete(num);
		
		if(result) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}
}
