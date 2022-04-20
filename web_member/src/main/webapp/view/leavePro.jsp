<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//leaveForm에서 보낸값 가져오기(userid, password)
	String userid = request.getParameter("userid");
	String current_password = request.getParameter("current_password");
	 
	//db작업(leave) - delete
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	String path = "";
	//탈퇴성공 - 세션해제
	//페이지이동 - 성공: index, 실패:leaveForm
	if(dao.isLogin(userid, current_password) != null){
		if(dao.leave(userid, current_password)){
			JdbcUtil.commit(con);
			session.invalidate();
			path = "/index.jsp";
		}else{
			JdbcUtil.rollback(con);
			path = "leaveForm.jsp";
		}
		JdbcUtil.close(con);
		response.sendRedirect(path);
	}else{
		out.print("<script>");
		out.print("alert('비밀번호가 틀립니다.');");
		out.print("history.back();");
		out.print("</script>");
	}
	
	/* JdbcUtil.close(con);
	response.sendRedirect(path); */
%>