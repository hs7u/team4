document.addEventListener("DOMContentLoaded", function (event) {
	let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
	if (miniCart != null) {
		$("span.cart-count").removeClass("-none");
		$("span.cart-count").html(miniCart.length);
		let s_price = 0, total = 0;
		$(".minicart-product-list").empty();
		for (let i = 0; i < miniCart.length; i++) {
			s_price = miniCart[i].productPrice * miniCart[i].productQuantity;
			total += parseInt(s_price, 10)
			let cartList =
				`<li>
					<a href="#" class="image"><img src="${miniCart[i].productImage}" alt="Cart product Image"></a>
					<div class="content">
						<a href="#" class="title">${miniCart[i].productName}</a>
						<span class="quantity-price">${miniCart[i].productQuantity} x <span class="p_price">$ ${miniCart[i].productPrice}</span></span>
						<a href="#" class="remove miniRemove">×</a>
					</div>
				</li>`;
			$(".minicart-product-list").append(cartList);
		}

		$(".miniCartTotal").html(total);
	}
	let wishCart = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
	if (wishCart != null) {
		$("span.wishlist-count").removeClass("-none");
		$("span.wishlist-count").html(wishCart.length);

	}

	//移除minicart
	$(".miniRemove").on("click", function () {
		$(this).closest("li").fadeOut(0, function () {
			let s_price = 0, total = 0;
			let check = $(this).closest("li").find("a.title").text();
			let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
			for (let i = 0; i < miniCart.length; i++) {
				if (miniCart[i].productName.match(check) != null) {
					miniCart.splice(i, 1)
				}
			}
			$(this).closest("li").remove();
			localStorage.setItem("cart", JSON.stringify(miniCart));
			$("span.cart-count").html(miniCart.length);

			for (let i = 0; i < miniCart.length; i++) {
				s_price = miniCart[i].productPrice * miniCart[i].productQuantity ;
				total += parseInt(s_price, 10)
			}
			$(".miniCartTotal").html(total);
		})

	})

	//加入我的最愛
	$(document).on("click", "button.wishadd", function (e) {
		let target = $(this).attr("table-target");
		let cartAll = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
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
		}
		if (check == cartAll.length) {
			cartAll.push(select);
		}
		localStorage.setItem("wish", JSON.stringify(cartAll));
		$("span.wishlist-count").html(cartAll.length);

	})

	//加入購物車
	$(document).on("click", "button.add", function (e) {
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
				if (cartAll[i].productQuantity == null) {
					cartAll[i].productQuantity = 1;
				}
				cartAll[i].productQuantity = parseInt(cartAll[i].productQuantity, 10) + parseInt(select.productQuantity, 10);
				
			}
		}
		if (check == cartAll.length) {
			cartAll.push(select);
		}
		localStorage.setItem("cart", JSON.stringify(cartAll));
		$("span.cart-count").html(cartAll.length);

		let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
		let s_price = 0, total = 0;
		$(".minicart-product-list").empty();
		for (let i = 0; i < miniCart.length; i++) {
			s_price = miniCart[i].productPrice * miniCart[i].productQuantity ;
			total += parseInt(s_price, 10)
			let cartList =
				`<li>
					<a href="#" class="image"><img src="${miniCart[i].productImage}" alt="Cart product Image"></a>
					<div class="content">
						<a href="#" class="title">${miniCart[i].productName}</a>
						<span class="quantity-price">${miniCart[i].productQuantity} x <span class="p_price">$ ${miniCart[i].productPrice}</span></span>
						<a href="#" class="remove miniCartName">×</a>
					</div>
				</li>`
			$(".minicart-product-list").append(cartList);
		}

		$(".miniCartTotal").html(total);

	})
})
//$(".offcanvas-toggle").on("click", function (e) {
//	var cartList, s_price = 0, total = 0;
//	let miniCart = localStorage.getItem("cart") != null ? JSON.parse(localStorage.getItem("cart")) : [];
//	for (let i = 0; i < miniCart.length; i++) {
//		cartList +=
//			`<li>
//				<a href="product-details.jsp" class="image"><img src="${miniCart[i].productImage}" alt="Cart product Image"></a>
//				<div class="content">
//					<a href="product-details.jsp" class="title">${ miniCart[i].productName}</a>
//					<span class="quantity-price">${miniCart[i].productQuantity} x <span class="p_price">$ ${miniCart[i].productPrice/miniCart[i].productQuantity}</span></span>
//					<a href="#" class="remove">×</a>
//				</div>
//			</li>`
//	}
//	$(".minicart-product-list")
//		.empty()
//		.append(cartList);
//});
