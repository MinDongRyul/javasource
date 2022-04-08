<%@page import="member.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("utf-8"); 클래스를 이용한 form에서도 인코딩은 똑같이 해줘야한다.
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	//로그인 정보 세션 속송에 담기
	/* session.setAttribute("userid", userid);
	session.setAttribute("password", password); */
	session.setAttribute("loginDto", new LoginDto(userid, password));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 정보</h3>
	<p>userid : <%=userid %></p>
	<p>password : <%=password %></p>
	<p>age : <%=request.getAttribute("age") %></p>

	<p><a href="login_request2.jsp">이동</a></p>
</body>
</html>