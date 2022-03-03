document.addEventListener("DOMContentLoaded", function (event) {
	let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
	let miniWish = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
	if (miniCart != null) {
		$("span.cart-count").removeClass("-none");
		$("span.cart-count").html(miniCart.length);
	}
	if (miniWish != null) {
		$("span.wishlist-count").removeClass("-none");
		$("span.wishlist-count").html(miniWish.length);
	}
})

$("button.add").on("click", function (e) {
	let target = $(this).attr("table-target");
	let cartAll = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
	let select = {};
	select.cuatomerId = $("input[name = customerId]").val();
	select.productId = $("input." + target + "[name = productId]").val();
	select.productImage = $(this).parent().parent().prev(".product-thumb").find("img.pic").attr("src");
	select.productName = $("input." + target + "[name = productName]").val();
	select.productPrice = $("input." + target + "[name = productPrice]").val();
	select.productQuantity = $("input." + target + "[name = productQuantity]").val();
	let check = 0;
	for (let i = 0; i < cartAll.length; i++) {
		if (cartAll[i].productId != select.productId) {
			check++;
		}
		if (cartAll[i].productId == select.productId) {
			console.log(cartAll[i].productQuantity)
			cartAll[i].productQuantity = parseInt(cartAll[i].productQuantity, 10) + parseInt(select.productQuantity, 10);
			cartAll[i].productPrice = select.productPrice * cartAll[i].productQuantity;
		}
	}
	if (check == cartAll.length) {
		cartAll.push(select);
	}
	localStorage.setItem("cart", JSON.stringify(cartAll));
	$("span.cart-count").html(cartAll.length);
})

$("button.wishadd").on("click", function (e) {
	let target = $(this).attr("table-target");
	let wishAll = sessionStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
	let select = {};
	select.cuatomerId = $("input[name = customerId]").val();
	select.productId = $("input." + target + "[name = productId]").val();
	let check = 0;
	for (let i = 0; i < wishAll.length; i++) {
		if (wishAll[i].productId != select.productId) {
			check++;
		}
	}
	if (check == wishAll.length) {
		wishAll.push(select);
	}
	sessionStorage.setItem("wish", JSON.stringify(wishAll));
	$("span.wishlist-count").html(wishAll.length);
})

document.addEventListener("DOMContentLoaded", function (event) {
	var cartList;
	let miniCart = localStorage.getItem("cart") != null ? JSON.parse(localStorage.getItem("cart")) : [];
	for (let i = 0; i < miniCart.length; i++) {
		
		cartList +=
			`<li>
				<a href="product-details.html" class="image"><img src="assets/images/product/cart-product-1.webp" alt="Cart product Image"></a>
				<div class="content">
					<a href="product-details.html" class="title">${ miniCart[i].productName}</a>
					<span class="quantity-price">${miniCart[i].productQuantity} x <span class="p_price">$ ${miniCart[i].productPrice}</span></span>
					<a href="#" class="remove">×</a>
				</div>
			</li>`
	}
	$(".minicart-product-list")
		.empty()
		.append(cartList);
	
});
