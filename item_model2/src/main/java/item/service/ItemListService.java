package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import item.dao.ItemDAO;
import item.dto.ItemDTO;

public class ItemListService {
	//DAO와 타입을 맞춰주는게 편함
	public List<ItemDTO> listAll(){
		//DB  DAO
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		//dao에서 return 받은 값으로 받아주는게 편하다.
		List<ItemDTO> list = dao.getlist();
	
		close(con);
	
		return list;
	}
}
