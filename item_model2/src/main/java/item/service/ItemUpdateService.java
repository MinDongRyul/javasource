package item.service;
import static item.dao.JdbcUtil.*;

import java.sql.Connection;

import item.dao.ItemDAO;

public class ItemUpdateService {
	public boolean itemUpdate(int num, int price, String psize) {
		//db연결  dao
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		//dao
		boolean result = dao.update(num, price, psize);
		
		if(result) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}
}
