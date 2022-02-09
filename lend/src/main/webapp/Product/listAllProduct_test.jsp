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

<style>
  table {
	height: 30px;
	width: 875px;
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

<body bgcolor='#f1f5f9'>
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
	<c:forEach var="pVo" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">		
		<tr>
			<td>${pVo.productId}</td>
			<td>${pVo.productName}</td>
			<td>${pVo.productDescription}</td>
			<td>${pVo.productPrice}</td>
			<td><img src="${pVo.productImage}" alt=""></td>
			<td>${pVo.productInventory}</td> 
			<td>${pVo.customization}</td>
			<td>${pVo.customerProductPrice}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="update">
			     <input type="submit" value="修改">
                </FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="delete">
			     <input type="hidden" name="productId"  value="${pVo.productId}">
			     <input type="submit" value="刪除">
                </FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
