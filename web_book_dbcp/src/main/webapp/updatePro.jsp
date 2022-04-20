<%@page import="book.dao.BookDAO"%>
<%@page import="book.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//update.jsp넘긴 값 가져오기
	int code = Integer.parseInt(request.getParameter("code"));
	int price = Integer.parseInt(request.getParameter("price"));
	
	//db작업
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	boolean result = dao.update(code, price);

	//페이지이동
	String path = "";
	if(result){
		//성공 listPro.jsp,
		JdbcUtil.commit(con);
		path = "listPro.jsp";
	}else{
		//실패 update.jsp
		JdbcUtil.rollback(con);
		path = "update.jsp";
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>