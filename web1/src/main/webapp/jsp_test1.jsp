<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  html주석 -->
<%--  jsp주석 --%>
<%
	SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	out.print(sdf.format(date));
%>
<%=sdf.format(date) %>
</body>
</html>