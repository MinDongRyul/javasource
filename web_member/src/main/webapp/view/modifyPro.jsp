<%@page import="member.dao.JdbcUtil"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//modifyForm에서 넘긴 값 가져오기
	//새 비밀번호와 새비밀번호 확인이 같은 값인지 확인
	String current_password = request.getParameter("current_password");
	String new_password = request.getParameter("new_password");
	String confirm_password = request.getParameter("confirm_password");

	//db작업 
	//userid,현재 비밀번호가 일치하면(isLogin) 비밀번호 변경(changePassword)
	//dao;
	MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
	String userid = loginDto.getUserid(); 
	
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);

	String path = "";
	if(dao.isLogin(userid, current_password)==null){
		out.print("<script>");
		out.print("alert('현재 비밀번호를 확인해주세요');");
		out.print("history.back();");
		out.print("</script>");
	}else{
		//새 비밀번호와 새 비밀번호 확인이 같은 값인지 확인
		if(new_password.equals(confirm_password)){
			//비밀번호 변경
			boolean result = dao.changePassword(new_password, userid);
		
			//세션 해제
			//페이지이동
			//성공 - loginForm.jsp / 실패 - modifyForm.jsp
			if(result){
				JdbcUtil.commit(con);
				session.invalidate();
				path = "loginForm.jsp";
			}else{
				JdbcUtil.rollback(con);
				path = "modifyForm.jsp";
			}
		}else{
			out.print("<script>");
			out.print("alert('새 비밀번호와 현재 비밀번호가 다릅니다.');");
			out.print("history.back();");
			out.print("</script>");
		}
		JdbcUtil.close(con);
		response.sendRedirect(path);
	}
%>






