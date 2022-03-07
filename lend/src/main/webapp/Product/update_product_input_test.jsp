<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="web.Product.vo.*"%>
<%@ page import="java.util.*"%>
<%
ProductVO productVO = (ProductVO) request.getAttribute("currentProduct");
%>
<title>商品資料修改 - update_product_input.jsp</title>

<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display-swap');
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
button.btn_modal_close{
    height: 2.5rem;
    width: 10rem;
    cursor: pointer;
    border-radius: 15px;
    margin: 0 auto;
    display: block;
}
div.overlay{
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    background-color: hsla(0, 0%, 0%, .5);
    
    display: none;
}

/* 元素 article 置中及基本樣式 */
div.overlay > article{
    background-color: white;
    width: 90%;
    max-width: 800px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgb(255, 0, 0);
    padding: 10px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
.centerControl{
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>

</head>
<body bgcolor='#f1f5f9'>
	<main class="box">
		<div class="view">
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Product/updateProduct" enctype="multipart/form-data" id="myForm">
				<table>
					<tr>
						<td class="hint">商品標籤</td>
						<td>
							<label for="productCategoryCode">
							<input type="radio" class="" name="productCategoryCode" size="45" value="11" checked="<%=(productVO.getProductCategoryCode() == 11) ? true : false%>" />
								瓷畫
							</label>
							<label for="productCategoryCode" class="lineup">
								<input type="radio" class="" name="productCategoryCode" size="45" value="22" checked="<%=(productVO.getProductCategoryCode() == 22) ? true : false%>" />
								電烙
							</label>
							<label for="productCategoryCode">
								<input type="radio" class="" name="productCategoryCode" size="45" value="33" checked="<%=(productVO.getProductCategoryCode() == 33) ? true : false%>" />
								燒陶
							</label>
							<br>
							<label for="productCategoryCode">
								<input type="radio" class="" name="productCategoryCode" size="45" value="44" checked="<%=(productVO.getProductCategoryCode() == 44) ? true : false%>" />
								色鉛筆
							</label>
							<label for="productCategoryCode">
								<input type="radio" class="" name="productCategoryCode" size="45" value="55" checked="<%=(productVO.getProductCategoryCode() == 55) ? true : false%>" />
								水彩
							</label>
							<label for="productCategoryCode">
								<input type="radio" class="" name="productCategoryCode" size="45" value="66" checked="<%=(productVO.getProductCategoryCode() == 66) ? true : false%>" />
								壓克力彩繪
							</label>
						</td>
					</tr>
					<tr>
						<td class="hint">商品名稱</td>
						<td>
							<input type="TEXT" class="line" name="productName" size="45" value="<%=(productVO.getProductName() == null) ? "default" : productVO.getProductName()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品描述</td>
						<td>
							<input type="TEXT" class="line" name="productDescription" size="45" value="<%=(productVO.getProductDescription() == null) ? "default" : productVO.getProductDescription()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品價格</td>
						<td>
							<input type="TEXT" class="line" name="productPrice" size="45" value="<%=(productVO.getProductPrice() == null) ? "0" : productVO.getProductPrice()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品圖片</td>
						<td>
							<input type="file" name="productImage" id="" value="<%=(productVO.getProductImage() == null) ? "0" : productVO.getProductImage()%>" />
						</td>
					</tr>

					<tr>
						<td class="hint">商品庫存</td>
						<td>
							<input type="TEXT" class="line" name="productInventory" size="45" value="<%=(productVO.getProductInventory() == null) ? "0" : productVO.getProductInventory()%>" />
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
							<input type="TEXT" class="line" name="customerProductPrice" size="45" value="<%=(productVO.getCustomerProductPrice() == null) ? "0" : productVO.getCustomerProductPrice()%>" />
						</td>
					</tr>
					<tr>
						<td class="hint">商品上架狀態</td>
						<td>
							<label for="product_status">
								<input type="radio" class="" name="productStatus" size="45" value="1" checked="<%=(productVO.getProductStatus() == 1) ? true : false%>" />
								上架
							</label>
							<label for="product_status" class="lineup">
								<input type="radio" class="" name="productStatus" size="45" value="0" checked="<%=(productVO.getProductStatus() == 0) ? true : false%>" />
								下架
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<br>
							<input type="hidden" name="productId" value="<%=productVO.getProductId()%>">
							<input type="hidden" name="action" value="update">
							<input type="button" class="las" id="btn_sub" value="送出修改">
							<br>
						</td>
						<td>
							<br>
							<input type="button" class="button_active las" value="取消修改" onclick="location.href='./listAllProduct_test.jsp'" />
							<br>
						</td>
					</tr>
				</table>
			</FORM>
		</div>

		<div class="preview">
			<h3>原商品圖預覽</h3>	
			<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(productVO.getProductImage())%>" width="300px" height="100%" />
		</div>
	
	</main>
	<div class="overlay" style="border: none">
		<article>
			<p id="target" class="centerControl"></p>
			<button type="button" class="btn_modal_close">關閉</button>
		</article>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
	function imageForAjax(file){
    	let reader = new FileReader(); 
        reader.readAsArrayBuffer(file);
        reader.addEventListener("load", function () {
            let u = new Uint8Array(reader.result);
            return Array.from(u);
        })
	}
	function dofirst(){
		let pudate = {};
		$.fn.fail = function(){           
			this.fadeIn();
			$("button.btn_modal_close").on("click", function(){
				$("div.overlay").fadeOut();
			});
		};
		$.fn.success = function(){ 
			this.fadeIn();          
			$("button.btn_modal_close").on("click", function(){
				$("div.overlay").fadeOut("done", function(){
					window.location.assign("./listAllProduct_test.jsp");
				});
			});
		};
		$("input[name='product_image']").on("change" ,function(){
            pudate.productImage = imageForAjax(this.files[0])
    	})
		$("#btn_sub").on("click", function(){
			pudate.productId			= $('input[name="productId"]').val();
			pudate.productCategoryCode  = $('input[name="productCategoryCode"]:checked').val();
			pudate.customerProductPrice = $('input[name="customerProductPrice"]').val();
			pudate.customization        = $('input[name="customization"]:checked').val();
			pudate.productInventory     = $('input[name="productInventory"]').val();
			pudate.productName          = $('input[name="productName"]').val();
			pudate.productPrice         = $('input[name="productPrice"]').val();
			pudate.productDescription   = $('input[name="productDescription"]').val();
			pudate.productStatus		= $('input[name="productStatus"]:checked').val();
			pudate = JSON.stringify(pudate);
            axios({
              method: "post",
              url: "./updateProduct",
              data: pudate,
              headers: { "Content-Type": "application/json" },
            }).then(res => {
				let t = document.getElementById("target");
				let text = res.data;
				t.innerHTML = text;
				if(text.match(/success/) != null){
					$("div.overlay").success();
				}else{
					$("div.overlay").fail();
				}
			})
		})
	}
	window.addEventListener('load',dofirst);
</script>
</html>