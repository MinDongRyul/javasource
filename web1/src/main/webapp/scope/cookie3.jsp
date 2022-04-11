<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키 정보 가지고 오기
	//쿠키 정보가 없다면 기본 값은 korea로 설정
	String languege = "korea";

	String cookie = request.getHeader("Cookie");
	if(cookie != null){
		Cookie cookies[] = request.getCookies();
		
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("languege")){
				languege = cookies[i].getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(languege.equals("korea")){
		out.print("<h3>안녕하세요. 이것은 쿠키 예제입니다.");
	}else {
		out.print("<h3>Hello. This is Cookie example");
	}
%>
<form action="cookie_set.jsp" method="post">
	<input type="radio" name="languege" id="" value="korea"   <% if(languege.equals("korea")){ %> checked<%} %>/>한국어
	<input type="radio" name="languege" id="" value="english" <% if(languege.equals("english")){ %> checked<%} %>/>영어
	<input type="submit" value="설정" />
</form>
</body>
</html>