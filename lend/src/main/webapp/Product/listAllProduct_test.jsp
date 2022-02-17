<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	height: 70px;
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
		<th>商品編號</th>
		<th>商品名稱</th>
		<th>商品描述</th>
		<th>商品價格</th>
		<th>圖片</th>
		<th>庫存</th>
		<th>客製</th>
		<th>客製價格</th>
		<th>狀態</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="pVo" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" >		
		<tr>
			<td>${pVo.productId}</td>
			<td>${pVo.productName}</td>
			<td>${pVo.productDescription}</td>
			<td>${pVo.productPrice}</td>
			<%-- <td><img src="<%=request.getContextPath()%>/Product/Image?img=${pVo.productId}" alt="" width="50px" height="50px"></td> --%>
			<c:set var="image" scope="page" value="${pVo.productImage}" />
			<td><img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(((byte[])pageContext.getAttribute("image"))) %>" width="50px" height="50px"/></td>
			<td>${pVo.productInventory}</td> 
			<td>${pVo.customization eq 0 ? "否": "是"}</td>
			<td>${pVo.customerProductPrice}</td>
			<td>${pVo.productStatus eq 0 ? "下架中": "上架中"}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="transform">
                 <input type="hidden" name="productId" value="${pVo.productId}">  
			     <input type="submit" class="las" value="修改">
                </FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="delete">
			     <input type="hidden" name="productId"  value="${pVo.productId}">
			     <input type="submit"  class="las" value="刪除">
                </FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

