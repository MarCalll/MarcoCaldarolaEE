<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="1"></meta>
<title>Insert title here</title>
</head>
<body>

	<%
	Date date = new Date();
	out.print("<h2 align = \"center\">" + date.toString() + "</h2>");
	%>

	<%
	out.print("<h2 align = \"center\">" + (new java.util.Date()).toLocaleString() + "</h2>");
	%>

</body>
</html>