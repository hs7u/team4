<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.Product.vo.*"%>
<%@ page import="java.util.*"%>
<%
ProductVO productVO = (ProductVO) request.getAttribute("currentProduct");
%>
<title>商品資料修改 - update_product_input.jsp</title>

<link rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

<style>
* {
	font-family: 'Poppins', sans-serif;
	font-size: 12px;
}

table {
	width: 830px;
	padding: 1.2rem .4rem;
	border-radius: 10px;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	margin: 0;
	padding: 1.2px;
}

h3 {
	font-size: 18px;
}

label {
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

input.las:hover {
	cursor: pointer;
	background-color: #666666;
	color: white;
}

.line {
	width: 20rem;
}

.lineup {
	margin-left: 1rem;
}

.secline {
	margin-left: 2rem;
}

.hint {
	width: 9rem;
}

.box {
	display: flex;
}

.view {
	max-width: 500px;
}

.preview {
	background-color: transparent;
	width: 400px;
	height: 100%;
	position: relative;
	display: inline-block;
}

.btn_sub {
	width: 5rem;
}

button {
	border: none;
	text-align: center;
	height: 2rem;
	width: 5rem;
	cursor: pointer;
	border-radius: 15px;
}
</style>

</head>
<body bgcolor='#f1f5f9'>
	<main class="box">
		<div class="view">
			<h3>商品資料修改</h3>

			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" enctype="multipart/form-data">
				<table>
					<tr>
						<td class="hint">商品標籤</td>
						<td>
							<label for="product_category_code">
							<input type="radio" class="" name="product_category_code" size="45" value="11" checked="<%=(productVO.getProductCategoryCode() == 11) ? true : false%>" />
								瓷畫
							</label>
							<label for="product_category_code" class="lineup">
								<input type="radio" class="" name="product_category_code" size="45" value="22" checked="<%=(productVO.getProductCategoryCode() == 22) ? true : false%>" />
								電烙
							</label>
							<label for="product_category_code">
								<input type="radio" class="" name="product_category_code" size="45" value="33" checked="<%=(productVO.getProductCategoryCode() == 33) ? true : false%>" />
								燒陶
							</label>
							<br>
							<label for="product_category_code">
								<input type="radio" class="" name="product_category_code" size="45" value="44" checked="<%=(productVO.getProductCategoryCode() == 44) ? true : false%>" />
								色鉛筆
							</label>
							<label for="product_category_code">
								<input type="radio" class="" name="product_category_code" size="45" value="55" checked="<%=(productVO.getProductCategoryCode() == 55) ? true : false%>" />
								水彩
							</label>
							<label for="product_category_code">
								<input type="radio" class="" name="product_category_code" size="45" value="66" checked="<%=(productVO.getProductCategoryCode() == 66) ? true : false%>" />
								壓克力彩繪
							</label>
						</td>
					</tr>
					<tr>
						<td class="hint">商品名稱</td>
						<td>
							<input type="TEXT" class="line" name="product_name" size="45" value="<%=(productVO.getProductName() == null) ? "default" : productVO.getProductName()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品描述</td>
						<td>
							<input type="TEXT" class="line" name="product_description" size="45" value="<%=(productVO.getProductDescription() == null) ? "default" : productVO.getProductDescription()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品價格</td>
						<td>
							<input type="TEXT" class="line" name="product_price" size="45" value="<%=(productVO.getProductPrice() == null) ? "0" : productVO.getProductPrice()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品圖片</td>
						<td>
							<input type="file" name="product_image" id="" value="<%=(productVO.getProductImage() == null) ? "0" : productVO.getProductImage()%>" />
						</td>
					</tr>

					<tr>
						<td class="hint">商品庫存</td>
						<td>
							<input type="TEXT" class="line" name="product_inventory" size="45" value="<%=(productVO.getProductInventory() == null) ? "0" : productVO.getProductInventory()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">是否可客製化</td>
						<td>
							<label for="customization">
								<input type="radio" class="" id="cz" name="customization" size="45" value="1" checked="<%=(productVO.getCustomization() == 1) ? true : false%>" />
								是
							</label>
							<label for="customization" class="lineup secline">
								<input type="radio" class="" id="cz" name="customization" size="45" value="0" checked="<%=(productVO.getCustomization() == 0) ? true : false%>" />
								否
						</label>
						</td>
					</tr>
					<tr>
						<td class="hint">客製商品價格</td>
						<td>
							<input type="TEXT" class="line" name="customer_product_price" size="45" value="<%=(productVO.getCustomerProductPrice() == null) ? "0" : productVO.getCustomerProductPrice()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品上架狀態</td>
						<td>
							<label for="product_status">
								<input type="radio" class="" name="product_status" size="45" value="1" checked="<%=(productVO.getProductStatus() == 1) ? true : false%>" />
								上架
							</label>
							<label for="product_status" class="lineup">
								<input type="radio" class="" name="product_status" size="45" value="0" checked="<%=(productVO.getProductStatus() == 0) ? true : false%>" />
								下架
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<br>
							<input type="hidden" name="product_id" value="<%=productVO.getProductId()%>">
							<input type="hidden" name="action" value="update">
							<input type="submit" class="las" value="送出修改">
							<br>
						</td>
						<td>
							<br>
							<input type="button" class="las" class="button_active" value="取消修改" onclick="location.href='./listAllProduct_test.jsp';" />
							<br>
						</td>
					</tr>
					
				</table>
			</FORM>
		</div>

		<div class="preview">
			<h3>原商品圖預覽</h3>
			<br><br>
			<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(productVO.getProductImage())%>" width="300px" height="100%" />
		</div>
		
	</main>
</body>

</html>