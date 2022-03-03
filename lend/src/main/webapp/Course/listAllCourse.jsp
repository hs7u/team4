<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="web.Course.*"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="ProjectInterfaces.CourseInterface"%>
<%@ page import="web.Course.service.CourseService"%>
<%@ page import="web.Course.vo.CourseVO"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>

<%
    ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    CourseService csc = (CourseService) context.getBean("courseService");
	List<CourseVO> list = csc.getALL();
	pageContext.setAttribute("list",list);
%>

<html>
<head>
<title>所有課程資料 - listAllCourse.jsp</title>
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

<style>
    * {
        font-family: 'Poppins', sans-serif;	
    }
    table {
        background-color: white;
        border-radius: 10px;
        box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
    }
    
    th {
        text-align: center;
    }
    
    table, td {
        border: 0.1px solid white;
    }
    
    th, td {
        text-align: center;
        padding: .0 .3rem 0.2rem;
        font-size: 0.01rem;
        height: 80px;
        border-bottom: 0.5px solid #f0f0f0;
    }
    
    input {
        border-radius: 15px;
        padding: .5rem;
        border: none;
        outline: none;
        font-size: 6px;
    }
    
    input.las:hover {
        cursor: pointer;
        background-color: #666666;
        color: white;
        
    }
    </style>

</head>

<body bgcolor='#f1f5f9'>

<table>
	<tr>
		<th>課程編號</th>
		<th>課程名稱</th>
		<th>課程描述</th>
		<th>課程價格</th>
		<th>課程圖片</th>
		<th>課程狀態</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="cVo" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" >		
		<tr>
			<td>${cVo.courseId}</td>
			<td>${cVo.courseName}</td>
			<td>${cVo.courseDescribe}</td>
			<td>${cVo.coursePrice}</td>
			<c:set var="image" scope="page" value="${cVo.courseImage}" />
			<td><img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(((byte[])pageContext.getAttribute("image"))) %>" width="60px" height="50px"/></td>
			<td>${cVo.courseStatus eq 0 ? "下架中": "上架中"}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Course/update" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="transform">
                 <input type="hidden" name="courseId" value="${cVo.courseId}">  
			     <input type="submit" class="las" value="修改">
                </FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Course/update" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="delete">
			     <input type="hidden" name="coursId"  value="${cVo.courseId}">
			     <input type="submit"  class="las" value="刪除">
                </FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>