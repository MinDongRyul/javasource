<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//loginForm 넘긴 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	//db작업
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	MemberDTO loginDto = dao.isLogin(userid, password);
	
	JdbcUtil.close(con);
	
	//페이지이동(페이지를 이동해도 로그인이 유지 되도록 세션에 값을 담고 움직인다.)
	String path = "loginForm.jsp";
	if(loginDto != null){
		session.setAttribute("loginDto", loginDto);
	}
	/* else{//로그인 실패
		path = "loginForm.jsp";
	} */

	response.sendRedirect(path);
%>