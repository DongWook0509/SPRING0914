<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 1 ~ 100 사이 홀수를 출력하세요.(스크립트릿, 표현식) --%>
	<% for (int n = 1; n <= 100; n++) { %>
		<% if (n % 2 == 1) { %>
			<%=n%><br/>
		<% } %>
	<% } %>

	<%-- 같은 문제를 out 객체로 출력합니다. --%>
	<%
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				out.println(i + "<br/>");
			}
		}
	%>

</body>
</html>