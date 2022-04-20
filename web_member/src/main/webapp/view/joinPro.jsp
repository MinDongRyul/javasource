<%@page import="member.dao.JdbcUtil"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//joinForm.jsp에서 넘긴 값 가져오기
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));
	dto.setName(request.getParameter("name"));
	dto.setGender(request.getParameter("gender"));
	dto.setEmail(request.getParameter("email"));
	
	String confirm_password = request.getParameter("confirm_password");
	//db작업(register)
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	boolean result = dao.register(dto);
	String path = "";
	if(request.getParameter("password").equals(confirm_password)){
		//페이지 이동 : 성공 - loginForm, 실패 - joinForm
		if(result){
			JdbcUtil.commit(con);
			path = "loginForm.jsp";
		}else{
			JdbcUtil.rollback(con);
			path = "joinForm.jsp";
		}
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>