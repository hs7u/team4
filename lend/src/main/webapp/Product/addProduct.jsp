<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.Product.vo.*"%>


<%
  ProductVO productVO = (ProductVO) request.getAttribute("productVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>新增商品資料 - addProduct.jsp</title>
<link rel="stylesheet" href="css/addProduct.css">
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

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
  h4 {
    color: blue;
    display: inline;
  }

  table {
	width: 880px;
	margin-top: 0.1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
   
    
  }
  th, td {
    margin: auto;
    padding: 1px;
  }
  
  label{
    height: 100%;
    padding: .5rem;
    border: none;
    outline: none;
  }
  
  input {
    border-radius: 15px;
    padding: .5rem;
    border: none;
    outline: none;
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
                    <a href="./listAllProduct.jsp" class=""><span class="las la-receipt"></span>
                    <span>商品管理</span></a>
                </li>
                <li>
                    <a href="" class=""><span class="las la-user-circle"></span>
                    <span>帳號管理</span></a>
                </li>
                <li>
                    <a href="./addProduct.jsp" class="active"><span class="las la-clipboard-list"></span>
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
                新增商品
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
			
			<h3>新增商品資料</h3>

			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

			<FORM METHOD="post" ACTION="../Product/addNewProduct" name="form1" enctype="multipart/form-data">
				<table>


					<tr>
						<td>商品標籤</td>
						<td><input type="radio" name="product_category_code" size="45"
							value="<%= (productVO==null)? "11" : productVO.getProductCategoryCode()%>" />
							<label for="product_category_code">瓷畫</label> 
							<input type="radio"name="product_category_code" size="45"
							value="<%= (productVO==null)? "22" : productVO.getProductCategoryCode()%>" />
							<label for="product_category_code">電烙</label> 
							<input type="radio" name="product_category_code" size="45"
							value="<%= (productVO==null)? "33" : productVO.getProductCategoryCode()%>" />
							<label for="product_category_code">燒陶</label>
							<input type="radio" name="product_category_code" size="45"
							value="<%= (productVO==null)? "44" : productVO.getProductCategoryCode()%>" />
							<label for="product_category_code">色鉛筆</label>
							<input type="radio" name="product_category_code" size="45"
							value="<%= (productVO==null)? "55" : productVO.getProductCategoryCode()%>" />
							<label for="product_category_code">水彩</label>
							<input type="radio" name="product_category_code" size="45"
							value="<%= (productVO==null)? "66" : productVO.getProductCategoryCode()%>" />
							<label for="product_category_code">壓克力彩繪</label>
						</td>
					</tr>
					<tr>
						<td>商品名稱</td>
						<td><input type="TEXT" name="product_name" size="45"
							value="<%= (productVO==null)? "可客製｜色鉛筆｜手繪卡通人像" : productVO.getProductName()%>" /></td>
					</tr>
					<tr>
						<td>商品描述</td>
						<td><input type="TEXT" name="product_description" size="45"
							value="<%= (productVO==null)? "尺寸 : 長方形 6吋 10.2*15.2 cm 材質 : 寶虹水彩紙(完成後會噴上專用防霉噴漆)、Mijello水彩顏料" : productVO.getProductDescription()%>" /></td>
					</tr>
					<tr>
						<td>商品價格</td>
						<td><input type="TEXT" name="product_price" size="45"
							value="<%= (productVO==null)? "2500" : productVO.getProductPrice()%>" /></td>
					</tr>
					<tr>
					
					
						<td>商品圖片</td>
						<td><input type="file" name="product_image" id=""></td>
							
							
							
					</tr>
					<tr>
						<td>商品庫存</td>
						<td><input type="TEXT" name="product_inventory" size="45"
							value="<%= (productVO==null)? "3" : productVO.getProductInventory()%>" /></td>
					</tr>
					<tr>
						<td>是否可客製化</td>
						<td><input type="radio" name="customization" size="20"
							value="<%= (productVO==null)? "1" : productVO.getCustomization()%>" />
							<label for="customization">是</label> 
							<input type="radio"name="customization" size="45"
							value="<%= (productVO==null)? "0" : productVO.getCustomization()%>" />
							<label for="customization">否</label>
						</td>
					</tr>
					<tr>
						<td>客製商品價格</td>
						<td><input type="TEXT" name="customer_product_price" size="45"
							value="<%= (productVO==null)? "2500" : productVO.getCustomerProductPrice()%>" /></td>
					</tr>

				</table>
				<br> <input type="hidden" name="action" value="insert">
				<input type="submit" value="送出新增">
			</FORM>
		</main>
</body>
</html>