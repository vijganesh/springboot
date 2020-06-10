<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.example.demo.model.Alien" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if(null!=request.getAttribute("alienList")){
		List<Alien> listOfAliens = (List<Alien>)request.getAttribute("alienList");
		for(Alien alienObject:listOfAliens){
	%>
    <%=alienObject.getAname() %> with ID - <%=alienObject.getAid() %> is very  good in <%=alienObject.getTech() %>.<br>
    <%
		}
	}else{
		%>
		No&nbsp;results&nbsp;found.
		<%
	}
    %>
</body>
</html>