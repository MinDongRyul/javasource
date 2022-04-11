<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션 가져오기(한가지일 경우)
	//String product = (String)session.getAttribute("product"); // 오브젝트로 들어오기에 타입변환이 필요함
	
	ArrayList<String> productList = (ArrayList<String>)session.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>장바구니 보기</h3>
<%-- <h4><%=product %></h4> 한가지일 경우 --%>
<h4><%=productList %></h4>
<p><a href="cart.jsp">상품선택 페이지</a></p>
<p><a href="cart_remove.jsp">장바구니 비우기</a></p>
</body>
</html>