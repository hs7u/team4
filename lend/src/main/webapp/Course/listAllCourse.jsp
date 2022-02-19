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
<title>所有商品資料 - listAllCourse.jsp</title>
<link rel="stylesheet" href="css/listAllCourse.css">
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

<style>
 
  table {
	height: 30px;
	width: 900px;
	background-color: white;
	
	margin-top: 2px;
	margin-bottom: 2px;
  }
  table, th {
  height: 60px;
  font-size:  1rem;
  }
  
  table, th, td {
    border: 1px solid #ccc ;
  }
 
  th, td {
    text-align: center;
    font-size:  0.3rem;
  }
</style>

</head>

<body bgcolor='white'>
   <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <h2><span class="lab la-accusoft"></span><span>studio4art</span></h2>
        </div>
        <div class="sidebar-menu">
            <ul>
                <li>
                    <a href="" class=""><span class="las la-igloo"></span>
                    <span>Dashboard</span></a>
                </li>
                <li>
                    <a href="" class=""><span class="las la-users"></span>
                    <span>客戶管理</span></a>
                </li>
                <li>
                    <a href="" class=""><span class="las la-clipboard-list"></span>
                    <span>課程管理</span></a>
                </li>
                <li>
                    <a href="" class=""><span class="las la-shopping-bag"></span>
                    <span>訂單列表</span></a>
                </li>
                <li>
                    <a href="./listAllProduct.jsp" class="active"><span class="las la-receipt"></span>
                    <span>商品管理</span></a>
                </li>
                <li>
                    <a href="" class=""><span class="las la-user-circle"></span>
                    <span>帳號管理</span></a>
                </li>
                <li>
                    <a href="./addProduct.jsp" class=""><span class="las la-clipboard-list"></span>
                    <span>新增商品</span></a>
                </li>
            </ul>
        </div>
    </div>
    
    <div class="main-content">
        <header>
            <h2>
                <label for="nav-toggle">
                    <span class="las la-bars"></span>
                </label>
                課程管理
            </h2>
            <div class="search-wrapper">
                <span class="las la-search"></span>
                <input type="search" placeholder="Search here">
            </div>
            <div class="user-wrapper">
                <img src="image/cat.jpg" width="40px" height="40px" alt="">
                <div>
                    <h4>doge</h4>
                    <small>toor</small>
                </div>
            </div>
          </header>
          <main>

		 <h3>所有課程資料</h3>
	


<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>課程編號</th>
		<th>課程名稱</th>
		<th>課程描述</th>
		<th>課程價格</th>
		<th>課程圖片</th>
		<th>開課人數</th>
		<th>上架時間</th>
		<th>課程狀態</th>
<!-- 		<th>剩餘名額</th> -->
<!-- 		<th>截止報名日期</th> -->
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="CourseVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${CourseVO.courseId}</td>
			<td>${CourseVO.courseName}</td>
			<td>${CourseVO.courseDescription}</td>
			<td>${CourseVO.coursePrice}</td>
			<td>${CourseVO.courseImage}</td>
			<td>${CourseVO.minOfCourse}</td> 
			<td>${CourseVO.releasedTime}</td>
			<td>${CourseVO.courseState}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>../update_product_input" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="productId"  value="${ProductVO.productId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>../addNewProduct" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="courseId"  value="${ProductVO.productId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
</main>
</body>
</html>