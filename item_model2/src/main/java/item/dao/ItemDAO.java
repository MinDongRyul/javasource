package item.dao;
import static item.dao.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import item.dto.ItemDTO;

public class ItemDAO {
	private Connection con;

	public ItemDAO(Connection con) {
		super();
		this.con = con;
	}
	
	//CRUD 
	//R getlist(select는 무조건 리스트로 실행, 리스트새로 생성해서 새로 담아주기.)
	public List<ItemDTO> getlist(){
		List<ItemDTO> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select num,category,name,psize,price,register_at from item";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			//받는 것 필수
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setPsize(rs.getString("psize"));
				dto.setRegister_at(rs.getDate("register_at"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	
	// C
	// sql 
	public boolean insert(ItemDTO dto) {
		boolean flag = false;
		
		PreparedStatement pstmt = null;
		String sql = "insert into item(num,category,name,content,psize,price) values(item_seq.nextval,?,?,?,?,?)";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPsize());
			pstmt.setInt(5, dto.getPrice());
			
			int result = pstmt.executeUpdate(); 
			
			if(result > 0) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	//D
	public boolean delete(int num) {
		boolean flag = false;
		
		PreparedStatement pstmt = null;
		String sql = "delete from item where num = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0 ) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return flag;
	}
	
	//U
	public boolean update(int num, int price, String psize) {
		boolean flag = false;
	
		PreparedStatement pstmt = null;
		String sql = "update item set price = ?, psize = ? where num = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, psize);
			pstmt.setInt(3, num);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return flag;
	}
	
	//Search
	public List<ItemDTO> searchList(String category, String name) {
		List<ItemDTO> list = new ArrayList<>(); 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from item where category = ? and name = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, name);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setPrice(rs.getInt("price"));
				dto.setPsize(rs.getString("psize"));
				dto.setRegister_at(rs.getDate("register_at"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}






