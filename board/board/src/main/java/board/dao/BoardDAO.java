package board.dao;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.dto.SearchDTO;

public class BoardDAO {
	private Connection con;

	public BoardDAO(Connection con) {
		super();
		this.con = con;
	}
	
	//CURD
	//게시글 삽입, 삭제, 수정(게시글 수정, 조회수 수정), 조회, 전체조회
	public boolean insertArticle(BoardDTO dto) {
		boolean flag = false;
		
		PreparedStatement pstmt = null;
		
		String sql ="insert into BOARD(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) values(board_seq.nextval, ?, ?, ?, ?, ?, board_seq.currval, ?, ?)"; 
		
		try {
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getAttach());
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return flag;
	}
	
	//R(전체)
	public List<BoardDTO> listArticle(SearchDTO searchDto){
		List<BoardDTO> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//String sql = "select bno,title,name,regdate,readcount, re_ref, re_seq, re_lev from board order by re_ref desc, re_seq asc";
		String sql= "select * from (select rownum as rnum, A.* ";
			sql += " from (select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq ";
			sql += " from board ";
	        sql += " where bno > 0 order by re_ref desc, re_seq asc) A ";
	   	    sql += " where rownum <= ?) ";
		    sql += " where rnum > ?";
		    
		int start = searchDto.getPage() * searchDto.getAmount();
		int end = (searchDto.getPage() - 1) * searchDto.getAmount();
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegDate(rs.getDate("regDate"));
				dto.setReadCount(rs.getInt("readcount"));
				dto.setRe_Ref(rs.getInt("re_ref"));
				dto.setRe_Seq(rs.getInt("re_seq"));
				//list.jsp에서 사용하는 컬럼
				dto.setRe_Lev(rs.getInt("re_lev"));
				
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
	
	//전체 게시물 개수
	public int totalRows() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from board";
		
		int total = 0;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);	
			close(pstmt);
		}
		
		return total;
	}
	
	//S(한줄인 경우 리스트 X, DTO구조로 선언)
	public BoardDTO getRow(int bno){
		BoardDTO dto = null; 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select bno,name,title,content,attach,re_ref,re_seq,re_lev from board where bno = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				//댓글 작업시 필요한 부분
				dto.setRe_Ref(rs.getInt("re_ref"));
				dto.setRe_Seq(rs.getInt("re_seq"));
				dto.setRe_Lev(rs.getInt("re_lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}
	
	//조회수 업데이트
	public boolean hitUpdate(int bno) {
		boolean flag = false; 
		
		PreparedStatement pstmt = null;
		
		String sql = "update board set readcount = readcount + 1 where bno = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
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
	public boolean deleteArticle(int bno, String password) {
		boolean flag = false;
		
		PreparedStatement pstmt = null;
		String sql = "delete from board where bno = ? and password = ?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			int result = pstmt.executeUpdate();
			
			if(result > 0) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	//게시물 수정
	public boolean updateArticle(BoardDTO updatedto) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			if(updatedto.getAttach()!=null) {
				sql = "update board set title=?,content=?,attach=? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, updatedto.getTitle());
				pstmt.setString(2, updatedto.getContent());
				pstmt.setString(3, updatedto.getAttach());
				pstmt.setInt(4, updatedto.getBno());
				pstmt.setString(5, updatedto.getPassword());
			}else {
				sql = "update board set title=?, content=? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, updatedto.getTitle());
				pstmt.setString(2, updatedto.getContent());;
				pstmt.setInt(3, updatedto.getBno());
				pstmt.setString(4, updatedto.getPassword());
			}
			
			int flag = pstmt.executeUpdate();
			
			if(flag > 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//댓글
	public boolean reply(BoardDTO replyDto) {
		boolean flag = false;
		
		PreparedStatement pstmt = null;
		String sql = ""; 
		
		try {
			
			int re_ref = replyDto.getRe_Ref();
			int re_seq = replyDto.getRe_Seq();
			int re_lev = replyDto.getRe_Lev();
			
			//기존 댓글에 대한 업데이트
			
			sql = "update board set re_seq = re_seq + 1 where re_ref = ? and re_seq > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);

			int updateCnt = pstmt.executeUpdate();
			
			close(pstmt);
			
			//댓글 삽입
			//댓글작성(re_ref : 원본글의 re_ref값과 동일하게 삽입,
			//		re_lev : 원보글의 re_lev + 1 삽입
			//	    re_weq : 원본글의 re_seq + 1 삽입) 
			
			re_lev = re_lev + 1;
			re_seq = re_seq + 1;
			sql = "insert into BOARD(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) ";
			sql += "values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, replyDto.getName());
			pstmt.setString(2, replyDto.getPassword());
			pstmt.setString(3, replyDto.getTitle());
			pstmt.setString(4, replyDto.getContent());
			pstmt.setString(5, replyDto.getAttach());
			pstmt.setInt(6, re_ref);
			pstmt.setInt(7, re_lev);
			pstmt.setInt(8, re_seq);
			
			int insertCnt = pstmt.executeUpdate();
			
			if(insertCnt > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	//검색
	public List<BoardDTO> searchList(SearchDTO searchDto){
		List<BoardDTO> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		try {
			sql = "select bno, title, name, regdate, readcount, re_ref, re_seq, re_lev from board where " + searchDto.getCriteria() + " like ? order by re_ref desc, re_seq asc";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchDto.getKeyword()+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDTO dto = new BoardDTO();
				
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setRegDate(rs.getDate("regdate"));
				dto.setReadCount(rs.getInt("readcount"));
				dto.setRe_Ref(rs.getInt("re_ref"));
				dto.setRe_Seq(rs.getInt("re_seq"));
				dto.setRe_Lev(rs.getInt("re_lev"));
				
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












