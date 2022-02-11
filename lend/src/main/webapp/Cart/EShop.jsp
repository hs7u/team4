<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="web.Product.service.ProductService"%>
<%@ page import ="org.hibernate.Session"%>
<%@ page import ="web.Product.vo.ProductVO"%>
<%@ page import="ProjectInterfaces.ProductInterface"%>

<%
	ProductService psc = new ProductService((Session)request.getAttribute("session"));
    ArrayList<ProductVO> list = psc.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
 <%@include file="includes/head.jsp" %>
 <title>Cart.jsp</title>
</head>
<body>
<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!list.isEmpty()) {
				for (ProductVO p : list) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="<%=request.getContextPath()%>/Product/Image?img=<%=p.getProductId()%>"alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getProductName() %></h5>
						<h6 class="price">價格: <%=p.getProductPrice() %></h6>
						<h6 class="category">客製化: <%
							if(p.getCustomization() == 1){
								 out.println("是");
							}else{
								 out.println("否");
							}
						%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="addToCart?id=<%=p.getProductId()%>">Add to Cart</a> <a
								class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getProductId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>