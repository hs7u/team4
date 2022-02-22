<%@page import="web.Customer.vo.CustomerVO"%>
<%@page import="web.Customer.dao.CustomerDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>帳號驗證成功</title>
<link rel="XXX" href="XXX" type="xxx"  >
</head>
<body>

<h1>帳號驗證成功</h1>

<%
String code = request.getParameter("code");


%>

<a href="<c:url value='../XXXX/login.jsp'  />">按此登入</a><p/>
</body>
</html>