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


<style>
  @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display-swap');
  
  table {
  border-radius: 10px;
	height: 80px;
	width: 850px;
	background-color: white;
  }
  
  table, th {
  height: 90px;
  
  }
  
  table, th, td {
    border: 0.1px solid white;
  }
 
  th, td {
    text-align: center;
    padding: .2rem 1rem;
    font-size:  0.1rem;
    height: 40px;
   
  }
  
   input {
    border-radius: 15px;
    padding: .5rem;
    border: none;
    outline: none;
  }
  

</style>




<body bgcolor='#f1f5f9'>
    <h3>所有商品資料</h3>	

<table>
	<tr>
		<th>商品編號</th>
		<th>商品名稱</th>
		<th>商品描述</th>
		<th>商品價格</th>
		<th>商品圖片</th>
		<th>庫存</th>
		<th>客製化</th>
		<th>客製價格</th>
		<th>狀態</th>
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
			<td><img src="<%=request.getContextPath()%>/Product/Image?img=${pVo.productId}" alt="" width="60px" height="50px"></td>
			<td>${pVo.productInventory}</td> 
			<td>${pVo.customization eq 0 ? "否": "是"}</td>
			<td>${pVo.customerProductPrice}</td>
			<td>${pVo.productStatus eq 0 ? "下架中": "上架中"}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" style="margin-bottom: 0px;">
			     <input type="hidden" name="action"  value="transform">
                 <input type="hidden" name="productId" value="${pVo.productId}">  
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
