<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//info.jsp에서 사용자가 넘긴 값 가져오기
	//String 형태로 값이 넘어옴
	request.setCharacterEncoding("utf-8"); // post라서 인코딩해줘야함
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String job = request.getParameter("job");
	String favorite[] = request.getParameterValues("favorite"); // 배열형태
	String gender = request.getParameter("gender");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	userid : <%=userid%>
</p>
<p>
	password : <%=password%>
</p>
<p>
	job : <%=job%>
</p>
<p>
	favorite : <%=Arrays.toString(favorite) %>
</p>
<p>
	gender : <%=gender%>
</p>
</body>
</html>