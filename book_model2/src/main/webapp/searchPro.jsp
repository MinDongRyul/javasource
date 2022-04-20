<%@page import="java.util.List"%>
<%@page import="book.dto.BookDTO"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.dao.JdbcUtil"%>
<%@page import="book.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//인코딩을 해주지 않으면 한글이 넘어왔을 때 keyword값이 인식하지 못해서 값 출력이 안된다.
	request.setCharacterEncoding("utf-8");
	//search.jsp 에서 넘긴 값 가져오기
	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");
	
	//db작업
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	List<BookDTO> list = dao.searchList(criteria, keyword);
	
	JdbcUtil.close(con);
	//페이지 이동
	//list.jsp
	request.setAttribute("list", list);
	pageContext.forward("list.jsp");
	
%>