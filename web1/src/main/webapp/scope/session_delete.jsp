<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//특정 세션 삭제
	session.removeAttribute("name");
	//원래 화면으로 돌아가기
	response.sendRedirect("sessionTest1.jsp");
%>