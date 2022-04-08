<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("languege",request.getParameter("languege"));
	cookie.setMaxAge(60*60*24);
	response.addCookie(cookie); // 애플리케이션 내용에 추가해주는 부분?
	
	response.sendRedirect("cookie3.jsp");
%>