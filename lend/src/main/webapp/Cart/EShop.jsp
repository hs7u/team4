<%@ page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="web.Product.service.ProductService"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="web.Product.vo.ProductVO"%>
<%@ page import="web.Cart.CartVO"%>
<%@ page import="ProjectInterfaces.ProductInterface"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>

<%
	ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	ProductService psc = (ProductService)context.getBean("productService");
    ArrayList<ProductVO> list = psc.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
 <%@include file="includes/head.jsp" %>
 <title>Cart.jsp</title>
 <style>
	.card-title {
		overflow:hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.btn_box{
		width:200px;
	}
	.left{
		text-align: center;
		margin-right:0.7rem;
		width : 7rem;
	}
	.right{
		margin-right: 5rem;
		width : 5rem;
	}
 </style>
</head>
<body>
<input type="hidden" name="customerId" value="${session.customerId}" style="display: none;">
<div class="container">
		<div class="row">
			<c:forEach var="pVo" items="${list}">
				<div class="col-md-3 my-3">
					<div class="card w-100">
						<c:set var="image" scope="page" value="${pVo.productImage}" />
						<img class="card-img-top" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(((byte[])pageContext.getAttribute("image"))) %>" alt="Card image cap"/>
						<div class="card-body">
							<h5 class="card-title">${pVo.productName}</h5>
							<h6 class="price">價格: ${pVo.productPrice}</h6>
							<h6 class="category">客製化: ${pVo.customization eq 0 ? "否": "是"}</h6>
							<div class="mt-3 d-flex justify-content-between btn_box">
								<button class="btn btn-dark left add" table-target="${pVo.productId}" href="./addToCart?id=${pVo.productId}">Add to Cart</button> 
								<button class="btn btn-primary right" href="./order-now?quantity=1&id=${pVo.productId}">Buy</button>
							</div>
						</div>
					</div>
					<FORM style="display: none;">
						<input type="hidden" class="${pVo.productId}" name="productId" value="${pVo.productId}">
						<input type="hidden" class="${pVo.productId}" name="productName" value="${pVo.productName}">
						<input type="hidden" class="${pVo.productId}" name="productPrice" value="${pVo.productPrice}">
						<input type="hidden" class="${pVo.productId}" name="productQuantity" value="1">
					</FORM>
				</div>
			</c:forEach>
		</div>
	</div>
<%@include file="includes/footer.jsp" %>
</body>
	<script>
		$("button.add").on("click", function(e){
			let target = $(this).attr("table-target");
			let cartAll = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
			let select = {};
			select.cuatomerId = $("input[name = customerId]").val();
			select.productId = $("input."+target+"[name = productId]").val();
			select.productName = $("input."+target+"[name = productName]").val();
			select.productPrice = $("input."+target+"[name = productPrice]").val();
			let check = 0;
			for(let i = 0 ; i < cartAll.length; i++){
				if(cartAll[i].productId != select.productId){
					check++;
				}
				if(cartAll[i].productProductId == select.productProductId){
					cartAll[i].productQuantity += select.productQuantity;
					cartAll[i].productPrice += select.productPrice;
				}
			}
			if(check == cartAll.length)
				cartAll.push(select);
			localStorage.setItem("cart", JSON.stringify(cartAll));
		})
	</script>
</html>