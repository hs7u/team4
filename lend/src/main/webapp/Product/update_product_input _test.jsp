<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.Product.vo.*"%>

<%
	ProductVO productVO = (ProductVO) request.getAttribute("currentProduct");
%>
<title>商品資料修改 - update_product_input.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='#f1f5f9'>

	<table id="table-1">
		<tr><td>
			<h3>商品資料修改 - update_product_input.jsp</h3>
		</td></tr>
	</table>
	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="../ProductUpdate" enctype="multipart/form-data">
		<table>
			<tr>
				<td>商品標籤</td>
				<td><input type="radio" name="product_category_code" size="45"
					value="11" checked="<%= (productVO.getProductCategoryCode() == 11) ? true : false %>" />
					<label for="product_category_code">瓷畫</label> 
					<input type="radio" name="product_category_code" size="45"
					value="22" checked="<%= (productVO.getProductCategoryCode() == 22) ? true : false %>" />
					<label for="product_category_code">電烙</label> 
					<input type="radio" name="product_category_code" size="45"
					value="33" checked="<%= (productVO.getProductCategoryCode() == 33) ? true : false %>" />
					<label for="product_category_code">燒陶</label>
					<input type="radio" name="product_category_code" size="45"
					value="44" checked="<%= (productVO.getProductCategoryCode() == 44) ? true : false %>" />
					<label for="product_category_code">色鉛筆</label>
					<input type="radio" name="product_category_code" size="45"
					value="55" checked="<%= (productVO.getProductCategoryCode() == 55) ? true : false %>" />
					<label for="product_category_code">水彩</label>
					<input type="radio" name="product_category_code" size="45"
					value="66" checked="<%= (productVO.getProductCategoryCode() == 66) ? true : false %>" />
					<label for="product_category_code">壓克力彩繪</label>
				</td>
			</tr>
			<tr>
				<td>商品名稱</td>
				<td><input type="TEXT" name="product_name" size="45"
					value="<%= (productVO.getProductName()==null)? "default" : productVO.getProductName()%>" /></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><input type="TEXT" name="product_description" size="45"
					value="<%= (productVO.getProductDescription() == null) ? "default" : productVO.getProductDescription()%>" /></td>
			</tr>
			<tr>
				<td>商品價格</td>
				<td><input type="TEXT" name="product_price" size="45"
					value="<%= (productVO.getProductPrice() == null) ? "0" : productVO.getProductPrice()%>" /></td>
			</tr>	
			<tr>
				<td>商品圖片</td>
				<td><input type="file" name="product_image" id=""></td>	
			</tr>
		
			<tr>
				<td>商品庫存</td>
				<td><input type="TEXT" name="product_inventory" size="45"
					value="<%= (productVO.getProductInventory() == null) ? "0" : productVO.getProductInventory()%>" /></td>
			</tr>
			<tr>
				<td>是否可客製化</td>
				<td><input type="radio" id="cz" name="customization" size="45"
					value="1" checked="<%= (productVO.getCustomization() == 1) ? true : false %>" />
					<label for="customization">是</label> 
					<input type="radio" id="cz" name="customization" size="45"
					value="0" checked="<%= (productVO.getCustomization() == 0) ? true : false %>" />
					<label for="customization">否</label>
				</td>
			</tr>
			<tr>
				<td>客製商品價格</td>
				<td><input type="TEXT" name="customer_product_price" size="45"
					value="<%= (productVO.getCustomerProductPrice() == null) ? "0" : productVO.getCustomerProductPrice()%>" /></td>
			</tr>
		</table>
	<br>
	<input type="hidden" name="productd_id" value="<%=productVO.getProductId()%>">
	<input type="submit" value="送出修改"></FORM>
</body>

</html>