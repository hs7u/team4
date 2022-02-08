<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="web.Product.service.ProductService"%>
<%@ page import ="org.hibernate.Session"%>
<%@ page import ="web.Product.vo.ProductVO"%>
<%@ page import="ProjectInterfaces.ProductInterface"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	
	ProductService psc = new ProductService((Session)request.getAttribute("session"));
    ArrayList<ProductVO> list = psc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有商品資料 - listAllProduct.jsp</title>
<link rel="stylesheet" href="css/listAllProduct.css">
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
                商品管理
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

		 <h3>所有商品資料</h3>
	


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
		<th>商品編號</th>
		<th>商品名稱</th>
		<th>商品描述</th>
		<th>商品價格</th>
		<th>商品圖片</th>
		<th>商品庫存</th>
		<th>是否可客製化</th>
		<th>客製商品價格</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="ProductVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${ProductVO.productId}</td>
			<td>${ProductVO.productName}</td>
			<td>${ProductVO.productDescription}</td>
			<td>${ProductVO.productPrice}</td>
			<td>${ProductVO.productImage}</td>
			<td>${ProductVO.productInventory}</td> 
			<td>${ProductVO.customization}</td>
			<td>${ProductVO.customerProductPrice}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>../update_product_input" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="productId"  value="${ProductVO.productId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>../addNewProduct" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="productId"  value="${ProductVO.productId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
</main>
</body>
</html>